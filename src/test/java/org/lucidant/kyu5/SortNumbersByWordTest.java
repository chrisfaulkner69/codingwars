package org.lucidant.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortNumbersByWordTest {
    @Test
    void test() {
        assertArrayEquals(new int[]{4, 1, 3, 2}, SortNumbersByWord.sort(new int[]{1, 2, 3, 4}));

        assertArrayEquals(new int[]{8, 8, 9, 9, 10, 10}, SortNumbersByWord.sort(new int[]{8, 8, 9, 9, 10, 10}));

        assertArrayEquals(new int[]{9, 999, 99}, SortNumbersByWord.sort(new int[]{9, 99, 999}));

        assertArrayEquals(new int[]{88, 5, 99, 0}, SortNumbersByWord.sort(new int[]{0, 99, 88, 5}));

        // Duplicates
        assertArrayEquals(new int[]{88, 88, 5, 0}, SortNumbersByWord.sort(new int[]{0, 88, 88, 5}));
    }

    @Test
    void testWord() {
        assertThat(SortNumbersByWord.numToWord(99)).isEqualTo("ninety nine");
    }

    @Test
    void testSortBetter() {
        assertArrayEquals(new int[]{4, 1, 3, 2}, SortNumbersByWord.sortBetter(new int[]{1, 2, 3, 4}));

        assertArrayEquals(new int[]{8, 8, 9, 9, 10, 10}, SortNumbersByWord.sortBetter(new int[]{8, 8, 9, 9, 10, 10}));

        assertArrayEquals(new int[]{9, 999, 99}, SortNumbersByWord.sortBetter(new int[]{9, 99, 999}));

        assertArrayEquals(new int[]{88, 5, 99, 0}, SortNumbersByWord.sortBetter(new int[]{0, 99, 88, 5}));
        assertArrayEquals(new int[]{88, 88, 5, 0}, SortNumbersByWord.sortBetter(new int[]{0, 88, 88, 5}));
    }

}