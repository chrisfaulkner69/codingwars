/**
 *
 */
package org.lucidant;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author chrisfaulkner
 *
 */
public class DigitalRoot {

	public static int digitalRoot(final int input) {
		int startValue = (input < 0) ? Math.abs(input) : input;
		while (startValue >= 10)
		{
			startValue = Arrays.stream(String.valueOf(startValue).split(""))
							   .map(Integer::valueOf)
							   .collect(Collectors.toList())
							   .stream()
							   .mapToInt(i -> i).sum();
		}
		return startValue;
	}
}
