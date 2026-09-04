package org.lucidant.interview.discount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiscountTest {
    @Test
    void noDiscountReturnsOriginalPrice() {
        assertEquals(100.0, new DiscountCalculator().applyDiscount(100.0, new NoDiscount()), 0.001);
    }

    @Test
    void given10PercentDiscountReturns_Discounted() {
        assertEquals(90.0, new DiscountCalculator().applyDiscount(100.0, new PercentageOff(0.1d)), 0.001);
    }

    @Test
    void givenFixedPercentDiscountReturns_Discounted() {
        assertEquals(85.0, new DiscountCalculator().applyDiscount(100.0, new FixedAmountOff(15.0d)), 0.001);

    }

    @Test
    void givenIllegalPercentDiscount_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new DiscountCalculator().applyDiscount(100.0, new PercentageOff(0.25d)));
    }

    @Test
    void givenIllegalPercentDiscountByNumberPlaces_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new DiscountCalculator().applyDiscount(100.0, new PercentageOff(0.155d)));
    }

}
