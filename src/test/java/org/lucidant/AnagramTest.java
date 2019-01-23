/**
 * 
 */
package org.lucidant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chrisfaulkner
 *
 */
class AnagramTest {

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.lucidant.codingwars.Anagram#isAnagram(String, String)}.
	 */
	@Test
	void testIsAnagram() {
	    assertTrue(Anagram.isAnagram("foefet", "toffee"));
	    assertTrue(Anagram.isAnagram("Buckethead", "DeathCubeK"));
	    assertTrue(Anagram.isAnagram("Twoo", "Woot"));
	    assertFalse(Anagram.isAnagram("apple", "pale"));
	}

	/**
	 * Test method for {@link org.lucidant.codingwars.Anagram#isAnagram(String, String)}.
	 */
	@Test
	void testVowelCount() {
		assertEquals( 5, Anagram.vowelCount("abracadabra"));
		assertEquals( 0, Anagram.vowelCount("bbxxy"));
		assertEquals(10, Anagram.vowelCount("aeiouxaeioux"));
	}
}
