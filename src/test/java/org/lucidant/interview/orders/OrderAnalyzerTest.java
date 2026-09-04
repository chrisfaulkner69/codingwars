package org.lucidant.interview.orders;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderAnalyzerTest {

    @Test
    void givenNullOrEmptyOrderList_whenGetTotalForCategory_thenReturnZero() {
        assertEquals(BigDecimal.ZERO, OrderAnalyzer.getTotalForCategory(null, Collections.emptyList()));
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
}
