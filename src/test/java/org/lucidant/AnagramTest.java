/**
 *
 */
package org.lucidant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chrisfaulkner
 *
 */
class AnagramTest {

	@Test
	void testIsAnagram() {
	    assertTrue(Anagram.isAnagram("foefet", "toffee"));
	    assertTrue(Anagram.isAnagram("Buckethead", "DeathCubeK"));
	    assertTrue(Anagram.isAnagram("Twoo", "Woot"));
	    assertFalse(Anagram.isAnagram("apple", "pale"));
	}

	@Test
	void testVowelCount() {
		assertEquals( 5, Anagram.vowelCount("abracadabra"));
		assertEquals( 0, Anagram.vowelCount("bbxxy"));
		assertEquals(10, Anagram.vowelCount("aeiouxaeioux"));
	}
}
