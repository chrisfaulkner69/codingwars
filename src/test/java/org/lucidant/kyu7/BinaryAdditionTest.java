package org.lucidant.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryAdditionTest {

    @Test
    void testBinaryAddition1() {
        int a = 1;
        int b = 1;
        String expected = "10";
        String actual = BinaryAddition.binaryAddition(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void testBinaryAddition2() {
        int a = 5;
        int b = 10;
        String expected = "1111";
        String actual = BinaryAddition.binaryAddition(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void testBinaryAddition3() {
        int a = 0;
        int b = 0;
        String expected = "0";
        String actual = BinaryAddition.binaryAddition(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void testBinaryAddition4() {
        int a = 51;
        int b = 12;
        String expected = "111111";
        String actual = BinaryAddition.binaryAddition(a, b);
        assertEquals(expected, actual);
    }
}
