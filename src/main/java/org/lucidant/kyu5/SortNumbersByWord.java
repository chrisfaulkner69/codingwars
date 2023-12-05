package org.lucidant.kyu5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
class SortNumbersByWord {

    private static final String[] UNITS = { "zero", "one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen" };
    private static final String[] TENS_WORDS = { "", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety" };

    /**
     * One of the solutions, keeps the number against the word, so you don't have to convert back from number to word,
     */
    public static int[] sortBetter(final int[] array) {
        return Arrays.stream(array)
                .mapToObj(i -> Map.entry(i, numToWord(i)))
                .sorted(Map.Entry.comparingByValue())
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    /**
     * Quite a few of the solutions used recursion to drill into the number.
     */
    public static String numToWord(final int num) {

        String word;
        if (num < 20) {
            word = UNITS[num];
        }
        else if (num < 100) {
            word = getWords(num, TENS_WORDS, 10, " ", "");
        }
        else if (num < 1000) {
            word = getWords(num, UNITS, 100, " hundred", " and ");
        }
        else {
            throw new IllegalArgumentException("num >= 1000");
        }
        return word;
    }

    private static String getWords(int num, String[] wordArray, int modOperator, String denomination, String and) {

        final String countWord = wordArray[num / modOperator];
        final int remainder = num % modOperator;
        return countWord + denomination + ((remainder > 0) ? and + numToWord(remainder) : "");
    }

    public static int[] sort(final int[] array) {

        // convert to words, sort, split up, back to words, convert to int  and to array
        return IntStream.of(array)
                .boxed()
                .map(SortNumbersByWord::numToWord)
                .sorted()
                .map(SortNumbersByWord::splitStringWithSpace)
                .map(SortNumbersByWord::convertWordsToNum)
                .mapToInt(i->i)
                .toArray();
    }

    public static List<String> splitStringWithSpace(String str) {
        return Collections.list(new StringTokenizer(str, " "))
                .stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }

    private static int convertWordsToNum(List<String> words) {
        int finalResult = 0;
        int intermediateResult = 0;
        for (String str : words) {
            // clean up string for easier processing
            str = str.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");
            if (str.equalsIgnoreCase("zero")) {
                intermediateResult += 0;
            } else if (str.equalsIgnoreCase("one")) {
                intermediateResult += 1;
            } else if (str.equalsIgnoreCase("two")) {
                intermediateResult += 2;
            } else if (str.equalsIgnoreCase("three")) {
                intermediateResult += 3;
            } else if (str.equalsIgnoreCase("four")) {
                intermediateResult += 4;
            } else if (str.equalsIgnoreCase("five")) {
                intermediateResult += 5;
            } else if (str.equalsIgnoreCase("six")) {
                intermediateResult += 6;
            } else if (str.equalsIgnoreCase("seven")) {
                intermediateResult += 7;
            } else if (str.equalsIgnoreCase("eight")) {
                intermediateResult += 8;
            } else if (str.equalsIgnoreCase("nine")) {
                intermediateResult += 9;
            } else if (str.equalsIgnoreCase("ten")) {
                intermediateResult += 10;
            } else if (str.equalsIgnoreCase("eleven")) {
                intermediateResult += 11;
            } else if (str.equalsIgnoreCase("twelve")) {
                intermediateResult += 12;
            } else if (str.equalsIgnoreCase("thirteen")) {
                intermediateResult += 13;
            } else if (str.equalsIgnoreCase("fourteen")) {
                intermediateResult += 14;
            } else if (str.equalsIgnoreCase("fifteen")) {
                intermediateResult += 15;
            } else if (str.equalsIgnoreCase("sixteen")) {
                intermediateResult += 16;
            } else if (str.equalsIgnoreCase("seventeen")) {
                intermediateResult += 17;
            } else if (str.equalsIgnoreCase("eighteen")) {
                intermediateResult += 18;
            } else if (str.equalsIgnoreCase("nineteen")) {
                intermediateResult += 19;
            } else if (str.equalsIgnoreCase("twenty")) {
                intermediateResult += 20;
            } else if (str.equalsIgnoreCase("thirty")) {
                intermediateResult += 30;
            } else if (str.equalsIgnoreCase("forty")) {
                intermediateResult += 40;
            } else if (str.equalsIgnoreCase("fifty")) {
                intermediateResult += 50;
            } else if (str.equalsIgnoreCase("sixty")) {
                intermediateResult += 60;
            } else if (str.equalsIgnoreCase("seventy")) {
                intermediateResult += 70;
            } else if (str.equalsIgnoreCase("eighty")) {
                intermediateResult += 80;
            } else if (str.equalsIgnoreCase("ninety")) {
                intermediateResult += 90;
            } else if (str.equalsIgnoreCase("hundred")) {
                intermediateResult *= 100;
            } else if (str.equalsIgnoreCase("thousand")) {
                intermediateResult *= 1000;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("million")) {
                intermediateResult *= 1000000;
                finalResult += intermediateResult;
                intermediateResult = 0;
            } else if (str.equalsIgnoreCase("billion")) {
                intermediateResult *= 1000000000;
                finalResult += intermediateResult;
                intermediateResult = 0;
            }
        }

        finalResult += intermediateResult;
        return finalResult;
    }
}
