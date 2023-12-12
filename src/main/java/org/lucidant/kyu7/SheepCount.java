/**
 *
 */
package org.lucidant.kyu7;

import java.util.stream.IntStream;

/**
 * <a href="https://www.codewars.com/kata/58e0f0bf92d04ccf0a000010">Code Wars Location</a>
 *
 */
public class SheepCount {

	public static int lostSheep(int[] fridayNightCounting, int[] saturdayNightCounting, int sheepTotal) {
		return sheepTotal - (IntStream.of(fridayNightCounting).sum() + IntStream.of(saturdayNightCounting).sum());
	}
}
