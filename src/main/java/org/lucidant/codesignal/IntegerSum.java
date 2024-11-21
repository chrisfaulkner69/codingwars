package org.lucidant.codesignal;

import java.util.Arrays;

public class IntegerSum {

    public static int solution(int n) {
        return Arrays.stream(Integer.toString(Math.abs(n))
                        .split(""))
                        .mapToInt(Integer::parseInt)
                        .sum();
    }
}
