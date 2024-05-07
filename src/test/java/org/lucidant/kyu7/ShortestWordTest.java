package org.lucidant.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestWordTest {

    @Test
    void testFindShort_EmptyString_ReturnsZero() {
        String input = "";
        int actual = ShortestWord.findShort(input);
        assertEquals(0, actual, "Expected length of shortest word: 0");
    }

    @Test
    void testFindShort_SingleWord_ReturnsWordLength() {
        String input = "word";
        int actual = ShortestWord.findShort(input);
        assertEquals(4, actual, "Expected length of shortest word: 4");
    }

    @Test
    void testFindShort_MultipleWords_ReturnsShortestWordLength() {
        String input = "one two three";
        int actual = ShortestWord.findShort(input);
        assertEquals(3, actual, "Expected length of shortest word: 3");
    }

    @Test
    void testFindShort_MultipleWordsWithSpacePadding_ReturnsShortestWordLength() {
        String input = " one   two three ";
        int actual = ShortestWord.findShort(input);
        assertEquals(3, actual, "Expected length of shortest word: 3");
    }
}
