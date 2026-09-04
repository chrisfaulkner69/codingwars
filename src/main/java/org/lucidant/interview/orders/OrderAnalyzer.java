package org.lucidant.interview.orders;

import java.math.BigDecimal;
import java.util.List;

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
}
