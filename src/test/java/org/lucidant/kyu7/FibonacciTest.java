package org.lucidant.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest
{

    @DisplayName("Illegal argument")
    @Test
    void fibIllegal()
    {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fib(0));
    }

    // 1, 1, 2, 3, 5, 8
    @DisplayName("The first position")
    @Test
    void fibPositionFirst()
    {
        assertEquals(1, Fibonacci.fib(1));
    }

    @DisplayName("The second position")
    @Test
    void fibPositionSecond()
    {
        assertEquals(1, Fibonacci.fib(2));
    }

    @DisplayName("The third position")
    @Test
    void fibPositionThird()
    {
        assertEquals(2, Fibonacci.fib(3));
    }

    @DisplayName("The fourth position")
    @Test
    void fibPositionFourth()
    {
        assertEquals(3, Fibonacci.fib(4));
    }

    @DisplayName("The fifth position")
    @Test
    void fibPositionFifth()
    {
        assertEquals(5, Fibonacci.fib(5));
    }

    @DisplayName("The sixth position")
    @Test
    void fibPositionSixth()
    {
        assertEquals(8, Fibonacci.fib(6));
    }

    @DisplayName("The twenty second position")
    @Test
    void fibPosition22()
    {
        // 20th and 21st    6765+10946 = 17711
        assertEquals(17711, Fibonacci.fib(22));
    }

}
