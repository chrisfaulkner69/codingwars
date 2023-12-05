package org.lucidant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeGeneratorTest {

	private PalindromeGenerator underTest;
	
	@BeforeEach
	void setUp() {
		underTest = new PalindromeGenerator();
	}

	@Test
	public void testIsPalindromeWithSuccess() {
		assertTrue(underTest.isPalindrome("otto"));
	}
	
	@Test
	public void testIsPalindromeWithFailure() {
		assertFalse(underTest.isPalindrome("noob"));
	}

	@Test
	public void testGenerateStringWithPalindrome() {
		assertEquals("otto", underTest.generateString("otto"));
	}
	
	@Test
	public void testGenerateStringWithCasePalindrome() {
		assertEquals("Otto", underTest.generateString("Otto"));
	}
	
	@Test
	public void testGenerateStringWithOddPalindrome() {
		assertEquals("oto", underTest.generateString("oto"));
	}
	
	@Test
	public void testGenerateStringWithoutPalindrome() {
		assertEquals("ottonoobTest123321tseTboonotto", underTest.generateString("ottonoobTest123"));
	}

}
