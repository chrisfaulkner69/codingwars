package org.lucidant.kyu5;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatin {
    private static final Pattern regex = Pattern.compile("(\\w)(\\w*)");
    private static final Pattern WORD = Pattern.compile("^([A-Za-z0-9]{1,})$");
    private static final String APPEND = "ay";

    public static String pigItFromWeb(String str) {
        return regex.matcher(str).replaceAll("$2$1ay");
    }

    /**
     * Converts a given sentence to Pig Latin.
     * Each word in the sentence is transformed by moving the first letter to the end and adding 'ay',
     * leaving punctuation marks untouched.
     *
     * @param str the input sentence to be converted to Pig Latin
     * @return the converted sentence in Pig Latin
     */
    public static String pigIt(String str) {
        return Arrays.stream(str.split("\\s"))
                .map(PigLatin::pigWord)
                .collect(Collectors.joining(" "));

    }

    /**
     * Converts a given word to Pig Latin.
     * If the input word consists solely of alphanumeric characters,
     * it rearranges the word by moving its first character to the end and appending 'ay'.
     *
     * @param str the input word to be converted to Pig Latin
     * @return the converted word in Pig Latin, or the original word if it contains non-alphanumeric characters
     */
    private static String pigWord(final String str) {
        if (!WORD.matcher(str).matches()) {
            return str;
        }
        return str.length() > 1 ?
                str.substring(1) + str.charAt(0) + APPEND
                : str + APPEND;

    }

}
