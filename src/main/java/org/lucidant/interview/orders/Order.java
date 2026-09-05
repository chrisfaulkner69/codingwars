package org.lucidant.interview.orders;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Order(String customer, Category category, BigDecimal amount) {
    public Order {
        Objects.requireNonNull(amount, "amount must not be null");
        amount = amount.setScale(2, RoundingMode.HALF_UP);
    }
}
