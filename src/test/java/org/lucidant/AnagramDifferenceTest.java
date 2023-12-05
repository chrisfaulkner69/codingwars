/**
 *
 */
package org.lucidant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class AnagramDifferenceTest {

	@DisplayName("Test various combos")
	@Test
	void test() {
		assertEquals(AnagramDifference.difference("",""),0);
		assertEquals(AnagramDifference.difference("a",""),1);
		assertEquals(AnagramDifference.difference("", "a"),1);
		assertEquals(AnagramDifference.difference("ab","a"),1);
		assertEquals(AnagramDifference.difference("ab","cd"),4);
		assertEquals(AnagramDifference.difference("codewars","hackerrank"),10);

		assertEquals(AnagramDifference.difference("aab","a"),2);
		assertEquals(AnagramDifference.difference("a","aab"),2);

		assertEquals(AnagramDifference.difference("pneumonoultramicroscopicsilicovolcanoconiosis",
												  "pneumonoultramicroscopicsilicovolcanoconiosis"),0);
	}

}
