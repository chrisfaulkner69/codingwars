/**
 *
 */
package org.lucidant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/5b1b27c8f60e99a467000041">Source</a>
 *
 * Given two words, how many letters do you have to remove from them to make them anagrams?
 *
 * @author chrisfaulkner
 *
 */
public class AnagramDifference {

	public static int difference(final String wordLeft, final String wordRight)
	{
		int sizeLeft = wordLeft == null ? 0 : wordLeft.trim().length();
		int sizeRight = wordRight == null ? 0 : wordRight.trim().length();

		// Quick heuristics to throw out simple cases
		if (sizeLeft == 0 && sizeRight > 0)
		{
			return sizeRight;
		}
		else if (sizeRight == 0 && sizeLeft > 0)
		{
			return sizeLeft;
		}
		else if (sizeLeft == 0 && sizeRight == 0)
		{
			return 0;
		}

		final List<String> lettersLeft = Arrays.stream(wordLeft.split("")).collect(Collectors.toList());
		final List<String> lettersRight = Arrays.stream(wordRight.split("")).collect(Collectors.toList());

		final Set<String> distinctLetters = new HashSet<>(lettersLeft);
		distinctLetters.addAll(lettersRight);

		int removalCount = 0;
		for (final String distinctLetter : distinctLetters)
		{
			// Only in right side. Times to remove is count on right.
			if (!lettersLeft.contains(distinctLetter))
			{
				removalCount = removalCount + (int) (lettersRight.stream().filter(letter -> letter.equals(distinctLetter)).count());
			}
			else if (!lettersRight.contains(distinctLetter))
			{
				removalCount = removalCount + (int) (lettersLeft.stream().filter(letter -> letter.equals(distinctLetter)).count());
			}
			else
			{
				int leftCount = (int) lettersLeft.stream().filter(letter -> letter.equals(distinctLetter)).count();
				int rightCount = (int) lettersRight.stream().filter(letter -> letter.equals(distinctLetter)).count();
				removalCount = removalCount + Math.abs(leftCount - rightCount);
			}
		}
		return removalCount;
	}

}

