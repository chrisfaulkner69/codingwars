package org.lucidant;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Get the number of words in a sentence.
 */
public class SentenceWordCount {

	/**
	 * Return the word count in the sentence with the greatest number of separate words.
	 */
    public int solution(final String string) {

		int numWordsInSentence = 0;
		if (string == null || string.length() <= 0)
		{
			return numWordsInSentence;
		}

		final String[] tokens = string.split("[\\.?!]");
		if (tokens.length > 0)
		{
			numWordsInSentence = Arrays.stream(tokens)
                    .filter(sentence -> !sentence.trim().isEmpty())
                    .map(sentence -> sentence.trim().split("\\s+").length)
                    .max(Comparator.naturalOrder())
                    .orElse(0);
		}
		return numWordsInSentence;
    }

}
