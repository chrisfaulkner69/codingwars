package org.lucidant.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangeCounterTest {
    @Test
    public void givenOneAndTwo_whenCountChange_thenThreeWays() {
        assertEquals(3, ChangeCounter.countChange(4,  new int[] {1,2}));
        assertEquals(4, ChangeCounter.countChange(10, new int[] {5,2,3}));
        assertEquals(0, ChangeCounter.countChange(11, new int[] {5,7}));
        assertEquals(1, ChangeCounter.countChange(0,  new int[] {1,2}));
    }

    @Test
    public void givenFiveAndTwoAndOne_thenTenWaysToMakeChange() {
        assertEquals(10, ChangeCounter.countChange(10, new int[] {5,2,1}));
    }
}
