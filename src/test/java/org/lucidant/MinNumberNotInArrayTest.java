package org.lucidant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinNumberNotInArrayTest {

	private MinNumberNotInArray solution;
	@BeforeEach
	void setUp() throws Exception {
		solution = new MinNumberNotInArray();
	}

	@Test
	void test() {
		assertEquals(2, solution.solution(new int[] {-1, 0, 1, 100}));
		
		assertEquals(5, solution.solution(new int[] {1, 3, 6, 4, 1, 2}));
		
		assertEquals(1, solution.solution(new int[] {-1, -3}));
		assertEquals(5, solution.solution(new int[] {1,2,3,4}));
	}

}
