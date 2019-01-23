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

	public static int lostSheeps(int[] fridayNightCounting, int[] saturdayNightCounting, int sheepsTotal) {
		return sheepsTotal - (IntStream.of(fridayNightCounting).sum() + IntStream.of(saturdayNightCounting).sum());
	}
}
