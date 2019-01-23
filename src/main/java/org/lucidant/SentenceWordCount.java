package org.lucidant;

import java.util.Arrays;
import java.util.Comparator;

public class SentenceWordCount {
	
    public int solution(final String S) {
		
		int numWordsInSentence = 0;
		if (S == null || S.length() <= 0)
		{
			return numWordsInSentence;
		}
		
		final String[] tokens = S.split("[\\.?!]");
		if (tokens.length > 0)
		{
//			for (String sentence : Arrays.stream(tokens).collect(Collectors.toList()))
//			{
//				if (!sentence.trim().isEmpty())
//				{
//					final String[] words = sentence.trim().split("\\s+");
//					if (words.length > numWordsInSentence)
//					{
//						numWordsInSentence = words.length;
//					}
//				}
//			}
			numWordsInSentence = Arrays.stream(tokens)
					.filter(sentence -> !sentence.trim().isEmpty())
					.map(sentence -> sentence.trim().split("\\s+").length)
					.max(Comparator.naturalOrder())
					.orElse(Integer.valueOf(0))
					.intValue();
		}
		return numWordsInSentence;
    }
    
}
