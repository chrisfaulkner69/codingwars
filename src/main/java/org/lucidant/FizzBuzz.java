/**
 *
 */
package org.lucidant;

import java.util.stream.IntStream;

/**
 * @author chrisfaulkner
 *
 */
public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public void doFizzBuzz(final int startNum, final int endNum) {

        for (int i = startNum; i <= endNum; i++) {
			System.out.printf("Input: %s Output: %s \n", i, getFizzBuzzString(i));
        }

    }

	public void doFizzBuzzIntStream(final int startNum, final int endNum) {
		IntStream.rangeClosed(startNum, endNum)
				.mapToObj(this::getFizzBuzzString)
				.forEach(System.out::println);
	}

	private String getFizzBuzzString(int number) {
		final boolean isDivThree = number % 3 == 0;
		final boolean isDivFive = number % 5 == 0;
		final StringBuilder result = new StringBuilder(10);

		if (!isDivThree && !isDivFive) {
			result.append(number);
		} else {
			if (isDivThree) {
				result.append(FIZZ);
			}
			if (isDivFive) {
				result.append(BUZZ);
			}
		}

		return result.toString();
	}

}
