/**
 *
 */
package org.lucidant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chrisfaulkner
 *
 */
public class Anagram {

    public static boolean isAnagram(final String word1, final String word2) {
        final String cleanWord1 = (word1 == null ? "" : word1.trim().toLowerCase());
        final String cleanWord2 = (word2 == null ? "" : word2.trim().toLowerCase());

        if (cleanWord1.length() != cleanWord2.length()) {
            return false;
        }

        final List<String> letters1 = getSortedLetters(cleanWord1);
        final List<String> letters2 = getSortedLetters(cleanWord2);

        return letters1.equals(letters2);
    }

    private static List<String> getSortedLetters(String word) {
        return Arrays.stream(word.split(""))
				.sorted()
				.toList();
    }

	private static final Set<String> VOWELS = new HashSet<>(5);
	static {
		VOWELS.add("A");
		VOWELS.add("E");
		VOWELS.add("I");
		VOWELS.add("O");
		VOWELS.add("U");
	}


	public static int vowelCount(final String word)
	{
		if (word == null || word.trim().isEmpty())
		{
			return 0;
		}
		return (int) Arrays.stream(word.toUpperCase().split("")).filter(VOWELS::contains).count();
	}
}
