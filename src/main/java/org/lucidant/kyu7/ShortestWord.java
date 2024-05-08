package org.lucidant.kyu7;

import java.util.Arrays;

/**
 * Given a string of space separated words, find the shortest.
 *
 * @see <a href="https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9/java">Source</a>
 */
public class ShortestWord {
    public static int findShort(String s) {
        return Arrays.stream(s.split(" "))
                .map(String::trim)
                .filter((token) -> !token.isEmpty())
                .mapToInt(String::length)
                .min()
                .orElse(0);
    }
}
