/**
 *
 */
package org.lucidant;

/**
 * The `DigitalRoot` class efficiently calculates the digital root of an integer by summing its digits iteratively until a single-digit number is obtained. The `digitalRoot` method handles the main logic, while the `calculateSumOfDigits` method assists in summing the digits of an integer.
 *
 *
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
