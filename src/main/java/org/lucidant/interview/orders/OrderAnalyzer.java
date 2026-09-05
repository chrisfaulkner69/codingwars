package org.lucidant.interview.orders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

public class OrderAnalyzer {

    public static BigDecimal getTotalForCategory(Category category, List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return orders.stream()
                .filter(order -> order.category() == category)
                .map(Order::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<String, List<Order>> getOrdersByCustomer(String customer, List<Order> orders) {
        if (customer == null || customer.isBlank() || orders == null || orders.isEmpty()) {
            return Collections.emptyMap();
        }
        List<Order> matching = orders.stream()
                .filter(order -> order.customer().equals(customer))
                .toList();
        if (matching.isEmpty()) {
            return Collections.emptyMap();
        }
        return Map.of(customer, matching);
    }

    public Map<String, List<Order>> groupByCustomer(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return Collections.emptyMap();
        }

        return orders.stream()
                .collect(groupingBy(Order::customer, Collectors.toList()));
    }

    public LinkedHashMap<String, BigDecimal> totalByCustomerSortedDescending(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return new LinkedHashMap<>(0);
        }

        // Make a map with customer name as key and sum of all amounts in their orders
        Map<String, BigDecimal> customerTotals = orders.stream()
                .collect(groupingBy(Order::customer, mapping(Order::amount, reducing(BigDecimal.ZERO, BigDecimal::add))));

        return customerTotals.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (existing, replacement) -> existing, LinkedHashMap::new));
    }

    public Optional<Order> mostExpensiveOrder(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return Optional.empty();
        }

        return orders.stream()
                .max(Comparator.comparing(Order::amount));
    }

    public List<Category> distinctCategories(List<Order> orders, OrderPredicate filter) {

        var orders1 = Objects.requireNonNullElse(orders, new ArrayList<Order>(0));

        return orders1.stream()
                .filter(filter::test)
                .map(Order::category)
                .distinct()
                .toList();
    }

    @FunctionalInterface
    public interface OrderPredicate {
        boolean test(Order order);
    }
}
