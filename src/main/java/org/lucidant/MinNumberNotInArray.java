/**
 *
 */
package org.lucidant;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chrisfaulkner
 *
 */
public class MinNumberNotInArray {

	private static final int DEFAULT_VALUE = 1;
	private static final int MAX = 100000;

    public int solution(final int[] array) {

		if (array == null || array.length == 0) {
			return DEFAULT_VALUE;
		}

		// Gets a set of the numbers, excluding negative ones
		Set<Integer> positiveNumbers = Arrays.stream(array)
				.boxed()
				.filter(num -> num > 0)
				.collect(Collectors.toSet());
		System.out.println(STR."Post clean: \{positiveNumbers}");

		return findSmallestMissingPositive(positiveNumbers);
    }

	private int findSmallestMissingPositive(Set<Integer> numbers) {
		for (int i = 1; i < MAX; i++) {
			if (!numbers.contains(i)) {
				return i;
			}
		}
		return DEFAULT_VALUE;
	}
}
