/**
 *
 */
package org.lucidant;

import java.util.Arrays;

/**
 * @author chrisfaulkner
 *
 */
public class ArrayIntersection {


    int findIntersection(int[] firstArray, int[] secondArray) {
        final int NO_INTERSECTION_FOUND = -1;

        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        int secondArrayIndex = 0;

        for (int firstArrayIndex = 0; firstArrayIndex < firstArrayLength; firstArrayIndex++) {
            secondArrayIndex = findMatchInSortedArrays(firstArray[firstArrayIndex], secondArray, secondArrayIndex, secondArrayLength);
            if (firstArray[firstArrayIndex] == secondArray[secondArrayIndex])
                return firstArray[firstArrayIndex];
        }

        return NO_INTERSECTION_FOUND;
    }

    int findMatchInSortedArrays(int value, int[] sortedArray, int startIndex, int endIndex) {
        while (startIndex < endIndex - 1 && sortedArray[startIndex] < value)
            startIndex += 1;
        return startIndex;
    }
}
