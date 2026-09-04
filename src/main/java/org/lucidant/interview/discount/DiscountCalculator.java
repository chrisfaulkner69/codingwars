package org.lucidant.interview.discount;

public class DiscountCalculator {

    public double applyDiscount(double price, Discount discount) {
            return switch (discount) {
                case PercentageOff p -> price * (1 - p.percent());
                case FixedAmountOff f -> price - f.amount();
                case NoDiscount n -> price;
            };
    }
}
