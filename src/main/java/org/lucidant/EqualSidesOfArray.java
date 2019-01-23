/**
 * 
 */
package org.lucidant;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author chrisfaulkner
 *
 */
public class EqualSidesOfArray {
	
	public int arrayPosition(int[] inputArray) {
		
		if (inputArray == null || inputArray.length == 0)
		{
			return 0;
		}
		
//		Arrays.asList(1,2).stream().
		
		final int arrayLength = inputArray.length;
		return IntStream.range(0, arrayLength)
				        .filter(i ->
				          Arrays.stream(Arrays.copyOfRange(inputArray, 0, i)).sum() ==
				          Arrays.stream(Arrays.copyOfRange(inputArray, i + 1, arrayLength)).sum()
				        )
				        .findFirst()
				        .orElse(-1);
		
		
		
//		int startPos = 0;
//		int leftEndPos = 0;
//		int rightEndPos = arrayLength - 1;
//		final int[] reversedArray = Arrays.copyOf(inputArray, arrayLength);
//		reverse(reversedArray, 0, arrayLength);
//		
//		int loopCount = 1;
//		while (loopCount <= arrayLength)
//		{
//			final int leftSum = getTotal(startPos, leftEndPos, inputArray);
//			final int rightSum = getTotal(startPos, rightEndPos, reversedArray);
//			if (leftSum == rightSum)
//			{
//				return loopCount-1;
//			}
//			leftEndPos++;
//			rightEndPos--;
//			loopCount++;
//		}
//		
//		return - 1;
	}

//	private int getTotal(final int startPos, final int endPos, int[] inputArray) {
//		int total = 0;
//		for (int i = 0; i < endPos; i++) {
//			total = total + inputArray[i];
//		}
//		return total;
//	}

	
    public static void reverse(final int[] array, final int startIndexInclusive, final int endIndexExclusive) {
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
