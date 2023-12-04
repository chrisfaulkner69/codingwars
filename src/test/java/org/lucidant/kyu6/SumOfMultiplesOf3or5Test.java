package org.lucidant.kyu6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfMultiplesOf3or5Test {

    private SumOfMultiplesOf3or5 sum;

    @BeforeEach
    void beforeEach() {
        sum = new SumOfMultiplesOf3or5();
    }

    @DisplayName("Below 3 is 0")
    @Test
    void testForLessThanThree() {
        assertEquals(0, sum.solution(3));
        assertEquals(0, sum.solutionStream(3));
    }

    @DisplayName("Below 5 is 3")
    @Test
    void testForFive() {
        assertEquals(3, sum.solution(5));
        assertEquals(3, sum.solutionStream(5));
    }

    @DisplayName("Below 6 is 8")
    @Test
    void testForSix() {
        assertEquals(8, sum.solution(6));
        assertEquals(8, sum.solutionStream(6));
    }

    @DisplayName("Below 10 is 3,5,6,9 sums to 23")
    @Test
    void testForFirstSimple() {
        assertEquals(23, sum.solution(10));
        assertEquals(23, sum.solutionStream(10));
    }

    @DisplayName("Below 20 is 3,5,6,9,10,12,15,18 sums to 78")
    @Test
    void testForTwenty() {
        assertEquals(78, sum.solution(20));
        assertEquals(78, sum.solutionStream(20));
    }

    @DisplayName("Below 21 is 3,5,6,9,10,12,15,18,20 sums to 98")
    @Test
    void testForTwentyOne() {
        assertEquals(98, sum.solution(21));
        assertEquals(98, sum.solutionStream(21));
    }
    @DisplayName("Below 1000 233168")
    @Test
    void testForThousand() {
        assertEquals(233168, sum.solution(1000));
        assertEquals(233168, sum.solutionStream(1000));
    }
}
