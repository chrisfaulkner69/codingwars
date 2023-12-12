package org.lucidant.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class SheepCountTest {

	@Test
	void test() {
        assertEquals(5, SheepCount.lostSheep(new int[] {1,2}, new int[] {3,4}, 15));
        assertEquals(6, SheepCount.lostSheep(new int[] {3,1,2}, new int[] {4,5}, 21));
	}

}
