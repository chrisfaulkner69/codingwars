package org.lucidant.interview.orders;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class OrderAnalyzerTest {

    private static final String DAVE_SMITH = "Dave Smith";
    private static final String EMMA_JONES = "Emma Jones";

    @Test
    void givenNullOrEmptyOrderList_whenGetTotalForCategory_thenReturnZero() {
        assertEquals(BigDecimal.ZERO, OrderAnalyzer.getTotalForCategory(null, emptyList()));
        assertEquals(BigDecimal.ZERO, OrderAnalyzer.getTotalForCategory(null, null));
    }

    @Test
    void givenMatchInList_whenGetTotal_thenReturn() {
        var order1 = new Order("Dave Smith", Category.ONLINE, BigDecimal.valueOf(2.34d));
        var order2 = new Order("Chris Jones", Category.IN_STORE, BigDecimal.valueOf(5.55d));

        assertEquals(BigDecimal.valueOf(2.34d),
                OrderAnalyzer.getTotalForCategory(Category.ONLINE, List.of(order1, order2)));
    }

    @Test
    void givenNullCategory_whenGetTotal_thenReturn() {
        var order1 = new Order("Dave Smith", Category.ONLINE, BigDecimal.valueOf(2.34d));
        var order2 = new Order("Chris Jones", Category.IN_STORE, BigDecimal.valueOf(5.55d));

        assertEquals(BigDecimal.ZERO,
                OrderAnalyzer.getTotalForCategory(null, List.of(order1, order2)));
    }

    @Test
    void givenNoMatchesToCategory_whenGetTotal_thenReturnZero() {
        var order1 = new Order("Dave Smith", Category.ONLINE, BigDecimal.valueOf(2.34d));
        var order2 = new Order("Chris Jones", Category.ONLINE, BigDecimal.valueOf(5.55d));

        assertEquals(BigDecimal.ZERO,
                OrderAnalyzer.getTotalForCategory(Category.IN_STORE, List.of(order1, order2)));
    }

    @Test
    void givenNegativeOrderValues_whenGetTotal_thenReturnIncludingDeductions() {
        var order1 = new Order("Dave Smith", Category.ONLINE, BigDecimal.valueOf(2.34d));
        var order2 = new Order("Chris Jones", Category.ONLINE, BigDecimal.valueOf(-5.55d));

        assertEquals(BigDecimal.valueOf(-3.21),
                OrderAnalyzer.getTotalForCategory(Category.ONLINE, List.of(order1, order2)));
    }

    @Test
    void givenVaryingPrecision_whenGetTotal_thenReturnRounded() {
        var order1 = new Order("Dave Smith", Category.ONLINE, BigDecimal.valueOf(2.342d));
        var order2 = new Order("Chris Jones", Category.ONLINE, BigDecimal.valueOf(5.551d));

        var expected = BigDecimal.valueOf(7.89);
        assertEquals(expected,
                OrderAnalyzer.getTotalForCategory(Category.ONLINE, List.of(order1, order2)));
    }

    @Nested
    class OrdersByCustomer {
        private final OrderAnalyzer orderAnalyzer = new OrderAnalyzer();

        @Test
        void givenNullOrEmptyCustomer_whenGet_thenEmptyMap() {
            assertTrue(orderAnalyzer.getOrdersByCustomer(null, emptyList()).isEmpty());
            assertTrue(orderAnalyzer.getOrdersByCustomer(" ", emptyList()).isEmpty());
        }

        @Test
        void givenNoMatchesToCustomer_whenGet_thenEmptyMap() {

            var order1 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(2.34d));
            var order2 = new Order(EMMA_JONES, Category.IN_STORE, BigDecimal.valueOf(2.34d));
            var order3 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(2.34d));

            assertTrue(orderAnalyzer.getOrdersByCustomer("Emma Smith", List.of(order1, order2, order3)).isEmpty());
        }

        @Test
        void givenMatchesToCustomer_whenGet_thenReturnMapWithOneKey() {

            var order1 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(2.34d));
            var order2 = new Order(EMMA_JONES, Category.IN_STORE, BigDecimal.valueOf(2.34d));
            var order3 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(2.34d));

            Map<String, List<Order>> map = orderAnalyzer.getOrdersByCustomer(DAVE_SMITH, List.of(order1, order2, order3));
            assertEquals(1, map.size());
            assertTrue(map.containsKey("Dave Smith"));
            assertEquals(2, map.get("Dave Smith").size());
        }
    }

    @Nested
    class GroupByCustomer {
        private final Order order1 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(5.10d));
        private final Order order2 = new Order(EMMA_JONES, Category.IN_STORE, BigDecimal.valueOf(2.10d));
        private final Order order3 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(4.90d));
        private final Order order4 = new Order(EMMA_JONES, Category.ONLINE, BigDecimal.valueOf(2.45d));
        private final Order order5 = new Order(EMMA_JONES, Category.ONLINE, BigDecimal.valueOf(2.45d));
        private final OrderAnalyzer orderAnalyzer = new OrderAnalyzer();

        @Test
        void givenNullOrEmptyCustomer_whenGet_thenEmptyMap() {
            assertTrue(orderAnalyzer.groupByCustomer(null).isEmpty());
            assertTrue(orderAnalyzer.groupByCustomer(emptyList()).isEmpty());
        }

        @Test
        void givenMoreThanOneEntryAndMultipleCustomers_whenGet_thenReturnGroupedMap() {

            var allOrders = List.of(order1, order2, order3, order4, order5);

            Map<String, List<Order>> groupedByCustomer = orderAnalyzer.groupByCustomer(allOrders);

            assertEquals(2, groupedByCustomer.size());
            assertEquals(2, groupedByCustomer.get(DAVE_SMITH).size());
            assertEquals(3, groupedByCustomer.get(EMMA_JONES).size());
            assertTrue(groupedByCustomer.get(DAVE_SMITH).contains(order1));
            assertTrue(groupedByCustomer.get(EMMA_JONES).contains(order2));
        }
    }

    @Nested
    class TotalByCustomer {
        private final Order order1 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(5.10d));
        private final Order order2 = new Order(EMMA_JONES, Category.IN_STORE, BigDecimal.valueOf(3.00d));
        private final Order order3 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(4.90d));
        private final Order order4 = new Order(EMMA_JONES, Category.ONLINE, BigDecimal.valueOf(2.55d));
        private final Order order5 = new Order(EMMA_JONES, Category.ONLINE, BigDecimal.valueOf(2.55d));
        private final OrderAnalyzer orderAnalyzer = new OrderAnalyzer();

        @Test
        void givenNullOrEmptyCustomer_whenGet_thenEmptyMap() {
            assertTrue(orderAnalyzer.totalByCustomerSortedDescending(null).isEmpty());
            assertTrue(orderAnalyzer.totalByCustomerSortedDescending(emptyList()).isEmpty());
        }

        @Test
        void givenMoreThanOneEntryAndMultipleCustomers_whenGet_thenReturnGroupedMap() {

            var allOrders = List.of(order1, order2, order3, order4, order5);

            LinkedHashMap<String, BigDecimal> groupedByCustomer = orderAnalyzer.totalByCustomerSortedDescending(allOrders);

            assertEquals(2, groupedByCustomer.size());
            assertEquals(BigDecimal.TEN.setScale(2, RoundingMode.HALF_UP), groupedByCustomer.get(DAVE_SMITH));
            assertEquals(new BigDecimal("8.10"), groupedByCustomer.get(EMMA_JONES));
        }
    }

    @Nested
    class MostExpensiveOrder {
        private final Order order1 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(5.10d));
        private final Order order2 = new Order(EMMA_JONES, Category.IN_STORE, BigDecimal.valueOf(3.00d));
        private final Order order3 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(4.90d));
        private final Order order4 = new Order(EMMA_JONES, Category.ONLINE, BigDecimal.valueOf(2.55d));
        private final Order order5 = new Order(EMMA_JONES, Category.ONLINE, BigDecimal.valueOf(2.55d));
        private final OrderAnalyzer orderAnalyzer = new OrderAnalyzer();

        @Test
        void givenNullOrEmptyOrderList_whenGetMostExpensive_thenEmptyMap() {
            assertTrue(orderAnalyzer.mostExpensiveOrder(null).isEmpty());
            assertTrue(orderAnalyzer.mostExpensiveOrder(emptyList()).isEmpty());
        }

        @Test
        void givenManyOrders_whenGetMostExpensive_thenReturnTop() {
            var orders = List.of(order1, order2, order3, order4, order5);

            // Act
            var mostExpensiveOrder = orderAnalyzer.mostExpensiveOrder(orders);

            mostExpensiveOrder.ifPresentOrElse((order) -> {
                assertEquals(BigDecimal.valueOf(5.10d).setScale(2, RoundingMode.HALF_UP), order.amount());
            }, () -> fail("Orders not found"));
        }
    }

    @Nested
    class DistinctCategories {
        private final Order order1 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(5.10d));
        private final Order order2 = new Order(EMMA_JONES, Category.IN_STORE, BigDecimal.valueOf(3.00d));
        private final Order order3 = new Order(DAVE_SMITH, Category.ONLINE, BigDecimal.valueOf(4.90d));
        private final Order order4 = new Order(EMMA_JONES, Category.ONLINE, BigDecimal.valueOf(2.55d));
        private final Order order5 = new Order(EMMA_JONES, Category.IN_STORE, BigDecimal.valueOf(2.55d));
        private final OrderAnalyzer orderAnalyzer = new OrderAnalyzer();

        @Test
        void givenNullOrEmptyOrderList_whenGetDistinct_thenEmptyMap() {

            assertTrue(orderAnalyzer.distinctCategories(null, (_) -> Boolean.FALSE).isEmpty());
            assertTrue(orderAnalyzer.distinctCategories(emptyList(), (_) -> Boolean.FALSE).isEmpty());
        }

        @Test
        void givenListOfOrders_whenGetDistinct_thenEmptyMap() {
            var orders = List.of(order1, order2, order3, order4, order5);

            assertEquals(2, orderAnalyzer.distinctCategories(orders, (_) -> Boolean.TRUE).size());
        }

        @Test
        void givenListOfOrders_whenGetDistinctAndSupplyAnImplementationToTest_thenEmptyMap() {
            var orders = List.of(order1, order2, order3, order4, order5);

            assertEquals(1, orderAnalyzer.distinctCategories(orders, this::checkValueOverFour).size());
        }

        public boolean checkValueOverFour(final Order order) {
            return order.amount().compareTo(BigDecimal.valueOf(4.00d)) > 0;
        }
    }
}
