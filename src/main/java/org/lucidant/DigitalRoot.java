/**
 *
 */
package org.lucidant;

/**
 * @author chrisfaulkner
 *
 */
public class DigitalRoot {

	public static int digitalRoot(final int input) {
		int startValue = (input < 0) ? Math.abs(input) : input;
		while (startValue >= 10) {
			startValue = calculateSumOfDigits(startValue);
		}
		return startValue;
	}

	private static int calculateSumOfDigits(int startValue) {
		return String.valueOf(startValue)
			.chars()
			.map(Character::getNumericValue)
			.sum();
	}
}
