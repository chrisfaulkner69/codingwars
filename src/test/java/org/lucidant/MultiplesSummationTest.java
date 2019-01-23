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
class MultiplesSummationTest {

	private MultiplesSummation summation;
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		summation = new MultiplesSummation();
	}

	@Test
	void test() {
		assertEquals(23, summation.solution(10));
	}

}
