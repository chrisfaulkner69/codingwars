package org.lucidant.kyu6;

import java.util.stream.IntStream;

/**
 * @see <a href="https://www.codewars.com/kata/58f5c63f1e26ecda7e000029">Source</a>
 */
public class MexicanWave {

    public static String[] wave(String str) {

        return IntStream.range(0, str.length())
            .mapToObj(n ->
                str.substring(0, n) + Character.toUpperCase(str.charAt(n)) + str.substring(n + 1)
            )
            .filter(a -> !a.equals(str))
            .toArray(String[]::new);
    }
}
