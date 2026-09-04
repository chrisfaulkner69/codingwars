package org.lucidant.interview.orders;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Order(String customer, Category category, BigDecimal amount) {
    public Order {
        amount = amount.setScale(2, RoundingMode.HALF_UP);
    }
}
