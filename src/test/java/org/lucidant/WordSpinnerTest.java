/**
 * 
 */
package org.lucidant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class WordSpinnerTest {

	private WordSpinner wordSpinner;
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		wordSpinner = new WordSpinner();
	}

	/**
	 * Test method for {@link org.lucidant.codingwars.WordSpinner#spinWords(String)}.
	 */
	@Test
	void testSpinWords() {
		assertEquals("Hey wollef sroirraw", wordSpinner.spinWords("Hey fellow warriors"));
	}

	@Test
	void testSpinWordsMixed() {
		assertEquals("This is rehtona test", wordSpinner.spinWords("This is another test"));
	}
	
	@Test
	void testSpinWordsAllLess() {
		assertEquals("This is a test", wordSpinner.spinWords("This is a test"));
	}
	
	@Test
	void testSpinWordsAllMore() {
		assertEquals("reteP dekcip delkcip reppeP", wordSpinner.spinWords("Peter picked pickled Pepper"));
	}
	
	@Test
	void testSpinWordsNull() {
		assertEquals("", wordSpinner.spinWords(null));
	}
}
