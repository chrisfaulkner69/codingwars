package org.lucidant;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Get the number of words in a sentence.
 */
public class SentenceWordCount {

	private static final String END_OF_SENTENCE_DELIMITER = "[\\.?!]";

    /**
     * Return the word count in the sentence with the greatest number of separate words.
     */
    public int solution(final String string) {

        int numWordsInSentence = 0;
        if (string == null || string.isEmpty()) {
            return numWordsInSentence;
        }

        final String[] tokens = string.split(END_OF_SENTENCE_DELIMITER);
        if (tokens.length > 0) {
            numWordsInSentence = Arrays.stream(tokens)
                    .filter(sentence -> !sentence.trim().isEmpty())
                    .map(sentence -> sentence.trim().split("\\s+").length)
                    .max(Comparator.naturalOrder())
                    .orElse(0);
        }
        return numWordsInSentence;
    }

}
