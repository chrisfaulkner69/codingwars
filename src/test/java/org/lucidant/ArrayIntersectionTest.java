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
class ArrayIntersectionTest {

	private ArrayIntersection solution;
	
	/**
     */
	@BeforeEach
	void setUp() {
		solution = new ArrayIntersection();
	}

	@Test
	void test() {
//		assertEquals(2, solution.solution(new int[] {1, 3,2,1}, new int[] { 4,2,5,3,2} ));
//		assertEquals(-1, solution.solution(new int[] {2,1}, new int[] {3,3} ));
//		assertEquals(-1, solution.solution(new int[] {1,1, 3}, new int[] { 4,2,5} ));
//		assertEquals(100, solution.solution(new int[] {1,1, 3, 9, 8 , 100, 101}, new int[] { 100, 4,2,5} ));
//		assertEquals(-1, solution.solution(new int[] {10}, new int[] { 11} ));
//		assertEquals(-1, solution.solution(new int[] {11}, new int[] { 10} ));
//		assertEquals(11, solution.solution(new int[] {10,11,11}, new int[] { 11,12} ));
		assertEquals(12, solution.solution(new int[] {12,13}, new int[] { 9,12} ));
		assertEquals(-1, solution.solution(new int[] {12,13}, new int[] { 9,14} ));
		assertEquals(-1, solution.solution(new int[] {14,13}, new int[] {1} ));
		assertEquals(-1, solution.solution(new int[] {1}, new int[] {2,3} ));
		
		assertEquals(99, solution.solution(new int[] {99,103,1065,10000}, new int[] {7,57,99,9999,10000} ));
	}

	
	@Test
	void testBreakCase() {
		assertEquals(99, solution.solution(new int[] {99,103,1065,10000}, new int[] {7,57,99,9999,10000} ));
	}
}
