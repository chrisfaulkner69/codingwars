package org.lucidant;

import java.util.Arrays;

public class Kata {
	public static int findEvenIndex(int[] inputArray) {
		if (inputArray == null || inputArray.length == 0) {
			return 0;
		}

		final int arrayLength = inputArray.length;

		int startPos = 0;
		int leftEndPos = 0;
		int rightEndPos = arrayLength - 1;
		final int[] reversedArray = Arrays.copyOf(inputArray, arrayLength);
		reverse(reversedArray, 0, arrayLength);

		int loopCount = 1;
		while (loopCount <= arrayLength) {
			final int leftSum = getTotal(startPos, leftEndPos, inputArray);
			final int rightSum = getTotal(startPos, rightEndPos, reversedArray);
			if (leftSum == rightSum) {
				return loopCount - 1;
			}
			leftEndPos++;
			rightEndPos--;
			loopCount++;
		}
		return - 1;
	}

	private static int getTotal(final int startPos, final int endPos, int[] inputArray) {
		int total = 0;
		for (int i = 0; i < endPos; i++) {
			total = total + inputArray[i];
		}
		return total;
	}

	private static void reverse(final int[] array, final int startIndexInclusive, final int endIndexExclusive) {
		if (array == null) {
			return;
		}
		int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
		int j = Math.min(array.length, endIndexExclusive) - 1;
		int tmp;
		while (j > i) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
			j--;
			i++;
		}
	}
}
