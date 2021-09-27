package org.lucidant.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualSidesOfAnArrayTest {

    @Test
    void whenInsufficientNumbers() {
        assertEquals(0, EqualSidesOfAnArray.findEvenIndex(new int[] {1}));
        assertEquals(-1, EqualSidesOfAnArray.findEvenIndex(new int[] {1,1000}));
    }

    @Test
    void whenSimpleCase() {
        assertEquals(3, EqualSidesOfAnArray.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
    }

}
