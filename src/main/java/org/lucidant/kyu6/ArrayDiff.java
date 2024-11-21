package org.lucidant.kyu6;

import java.util.Arrays;
import java.util.List;


/**
 * <a href="https://www.codewars.com/kata/523f5d21c841566fde000009">...</a>
 * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
 * It should remove all values from list a, which are present in list b keeping their order.
 */
public class ArrayDiff {

    public static int[] arrayDiff(int[] leftArr, int[] rightArr) {
        final List<Integer> right = Arrays.stream(rightArr).boxed().toList();

        return Arrays.stream(leftArr).boxed().toList().stream()
                .filter(n -> !right.contains(n))
                .mapToInt(i -> i)
                .toArray();
    }
}
