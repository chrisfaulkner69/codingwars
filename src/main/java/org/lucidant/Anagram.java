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

	public static boolean isAnagram(final String word1, final String word2)
	{
		final int word1Length = word1 == null ? 0 : word1.trim().length();
		final int word2Length = word2 == null ? 0 : word2.trim().length();
		if (word1Length != word2Length)
		{
			return false;
		}

		final List<String> letters1 = Arrays.stream(word1.trim().toLowerCase().split("")).sorted().toList();
		final List<String> letters2 = Arrays.stream(word2.trim().toLowerCase().split("")).sorted().toList();
		return letters1.equals(letters2);
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
