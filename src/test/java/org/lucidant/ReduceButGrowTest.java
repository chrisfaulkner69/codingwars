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
class ReduceButGrowTest {

	@Test
	void test() {
        assertEquals(6, ReduceButGrow.grow(new int[]{1,2,3}));
        assertEquals(16, ReduceButGrow.grow(new int[]{4,1,1,1,4}));
        assertEquals(64, ReduceButGrow.grow(new int[]{2,2,2,2,2,2}));
        assertEquals(-36, ReduceButGrow.grow(new int[]{9,-2,2}));
        assertEquals(303, ReduceButGrow.grow(new int[]{101,3}));
        assertEquals(2, ReduceButGrow.grow(new int[]{2}));
	}

	@Test
	void testSimple() {
		assertEquals(6, ReduceButGrow.growSimple(new int[]{1,2,3}));
		assertEquals(16, ReduceButGrow.growSimple(new int[]{4,1,1,1,4}));
		assertEquals(64, ReduceButGrow.growSimple(new int[]{2,2,2,2,2,2}));
		assertEquals(-36, ReduceButGrow.growSimple(new int[]{9,-2,2}));
		assertEquals(303, ReduceButGrow.growSimple(new int[]{101,3}));
		assertEquals(2, ReduceButGrow.growSimple(new int[]{2}));
	}
}
