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
class SheepCountTest {

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
        assertEquals(5, SheepCount.lostSheeps(new int[] {1,2}, new int[] {3,4}, 15)); 
        assertEquals(6, SheepCount.lostSheeps(new int[] {3,1,2}, new int[] {4,5}, 21));
	}

}
