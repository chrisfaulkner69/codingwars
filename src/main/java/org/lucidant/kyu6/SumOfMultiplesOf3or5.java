package org.lucidant.kyu6;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SumOfMultiplesOf3or5 {

    /** Chose to do this so that the multiple ints could be extracted from computation. */
    private static final int[] ints = {3,5};

    int solution(final int number) {
        int currentSum = 0;
         Set<Integer> counted = new HashSet<>();

        // iterating over an array
        for (final int x : ints) {
            // accessing each element of array
            for (int i = 0; i < number; i = i + x) {
                if (i % x == 0) {
                    if (!counted.contains(i)) {
                        currentSum = currentSum + i;
                        counted.add(i);
                    }
                }
            }
        }
        return currentSum;
    }

     int solutionStream(int number) {
        return IntStream.range(0, number)
            .filter(n -> (n % 3 == 0) || (n % 5 == 0))
            .sum();
    }
}
