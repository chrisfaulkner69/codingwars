package org.lucidant.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsogramNewTest {
    @Test
    void emptyStringIsIsogram() {
        assertTrue(IsogramNew.isIsogram(""));
    }

    @Test
    void simpleNonRepeatsStringIsIsogram() {
        assertTrue(IsogramNew.isIsogram("reTjua"));
    }

    @Test
    void givenRepeatingNonAlphabetChars_thenIsIsogram() {
        assertTrue(IsogramNew.isIsogram("reTj[[ua122"));
    }

    @Test
    void givenRepeatingAlphabetCharsOfDifferentCase_thenIsIsogram() {
        assertFalse(IsogramNew.isIsogram("reTtjhlomnb"));
    }
}
