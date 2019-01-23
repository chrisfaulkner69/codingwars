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
class EqualSidesOfArrayTest {

	private EqualSidesOfArray instance;
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		instance = new EqualSidesOfArray();
	}

	/**
	 * Test method for {@link org.lucidant.codingwars.EqualSidesOfArray#arrayPosition(int[])}.
	 */
	@Test
	void testSmall() {
		assertEquals(3, instance.arrayPosition(new int[] {1,2,3,4,3,2,1}));
	}

	@Test
	void testSmall3() {
		assertEquals(0, instance.arrayPosition(new int[] {1,-1,1}));
	}
	
	@Test
	void testSmallIndex0() {
		assertEquals(0, instance.arrayPosition(new int[] {20,10,-80,10,10,15,35}));
	}
	
	/**
	 * Test method for {@link org.lucidant.codingwars.EqualSidesOfArray#arrayPosition(int[])}.
	 */
	@Test
	void testArrayPosition1() {
		assertEquals(1, instance.arrayPosition(new int[]{1,100,50,-51,1,1}));
	}

	
	@Test
	void testLongArrayNoMatch() {
		assertEquals(-1, instance.arrayPosition(new int[]{99, 1010, 1,6, 109723, 102, 99, 101, 187, 1, 2, 3, 4 ,5, 6,7 }));
	}
	
}
