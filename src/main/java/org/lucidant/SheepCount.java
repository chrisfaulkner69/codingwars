/**
 *
 */
package org.lucidant;

import java.util.stream.IntStream;

/**
 * @author chrisfaulkner
 *
 */
public class SheepCount {

	public static int lostSheep(int[] fridayNightCounting, int[] saturdayNightCounting, int sheepTotal) {
		return sheepTotal - (IntStream.of(fridayNightCounting).sum() + IntStream.of(saturdayNightCounting).sum());
	}
}
