/**
 *
 */
package org.lucidant;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *  Find and return the middle where the sum on the left is the same as the sum of the right.
 *
 * @author chrisfaulkner
 *
 */
public class EqualSidesOfArray {

    /**
     * Find and return the middle where the sum on the left is the same as the sum of the right.
     * @param inputArray
     * @return
     */
	public int arrayPosition(final int[] inputArray)
    {

        if (inputArray == null || inputArray.length == 0)
        {
            return 0;
        }

        final int arrayLength = inputArray.length;
        return IntStream.range(0, arrayLength)
                        .filter(i ->
                                    Arrays.stream(Arrays.copyOfRange(inputArray, 0, i)).sum() ==
                                        Arrays.stream(Arrays.copyOfRange(inputArray, i + 1, arrayLength)).sum()
                               )
                        .findFirst()
                        .orElse(-1);
    }

    /**
     * Longer solution.
     * @param inputArray
     * @return
     */
    int arrayPositionOriginal(final int[] inputArray) {

        if (inputArray == null || inputArray.length == 0)
        {
            return 0;
        }
		final int arrayLength = inputArray.length;
		int leftEndPos = 0;
		int rightEndPos = arrayLength - 1;
		final int[] reversedArray = Arrays.copyOf(inputArray, arrayLength);
		reverse(reversedArray, 0, arrayLength);

		int loopCount = 1;
		while (loopCount <= arrayLength)
		{
			final int leftSum = getTotal(leftEndPos, inputArray);
			final int rightSum = getTotal(rightEndPos, reversedArray);
			if (leftSum == rightSum)
			{
				return loopCount-1;
			}
			leftEndPos++;
			rightEndPos--;
			loopCount++;
		}

		return - 1;
	}

	private int getTotal(final int endPos, final int[] inputArray) {
		int total = 0;
		for (int i = 0; i < endPos; i++) {
			total = total + inputArray[i];
		}
		return total;
	}


    public static void reverse(final int[] array, final int startIndexInclusive, final int endIndexExclusive) {
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
