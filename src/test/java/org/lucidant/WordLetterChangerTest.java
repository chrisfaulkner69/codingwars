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
class WordLetterChangerTest {

	private WordLetterChanger solution;
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		solution = new WordLetterChanger();
	}

	@Test
	void testNothing() {
		assertEquals("NOTHING", solution.solution("", ""));
	}
	@Test
	void testImpossible() {
		assertEquals("IMPOSSIBLE", solution.solution("child", "children"));
		assertEquals("IMPOSSIBLE", solution.solution("children", "child"));
	}
	@Test
	void testInsert() {
		assertEquals("INSERT e", solution.solution("nice", "niece"));
	}
	@Test
	void testDelete() {
		assertEquals("DELETE e", solution.solution("niece", "nice"));
	}
	@Test
	void testSwap() {
		assertEquals("SWAP a i", solution.solution("lad", "lid"));
	}

	@Test
	void testInsertEnd() {
		assertEquals("INSERT k", solution.solution("flic", "flick"));
	}

	@Test
	void testDeleteEnd() {
		assertEquals("DELETE k", solution.solution("flick", "flic"));
	}
	
	@Test
	void testImpossibleSameLength() {
		assertEquals("IMPOSSIBLE", solution.solution("children", "childaan"));
	}
}
