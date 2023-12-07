package org.lucidant.kyu6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://www.codewars.com/kata/54da5a58ea159efa38000836">Website</a>
 */
public class FindOdd {
    public static int findIt(final int[] a) {
        if (a == null || a.length <= 0) {
            return -1;
        }
        final List<Integer> allIntegers = Arrays.stream(a).boxed().toList();
        return IntStream.of(a)
                .sorted()
                .filter((value) -> Collections.frequency(allIntegers, value)%2 != 0)
                .findFirst()
                .orElse(-1);
    }

}
