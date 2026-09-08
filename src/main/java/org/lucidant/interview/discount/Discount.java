package org.lucidant.interview.discount;

import java.math.BigDecimal;

public sealed interface Discount permits PercentageOff, FixedAmountOff, NoDiscount {}

record PercentageOff(double percent) implements Discount {
    private static final double MAX_PERCENT_OFF = 0.2d;
    public PercentageOff {
        if (percent < 0 || percent > MAX_PERCENT_OFF) {
            throw new IllegalArgumentException(STR."percent must be 0-\{MAX_PERCENT_OFF}");
        }

        // BigDecimal.valueOf uses Double.toString(value) internally
        var bd = BigDecimal.valueOf(percent).stripTrailingZeros();
        if(bd.scale() > 2) {
            throw new IllegalArgumentException(STR."percent must have no more than 2 decimal places \{percent}");
        }
    }
}

record FixedAmountOff(double amount) implements Discount {}
record NoDiscount() implements Discount {}
