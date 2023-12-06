/**
 *
 */
package org.lucidant;

/**
 * @author chrisfaulkner
 *
 */
public class PalindromeGenerator {

	public boolean isPalindrome(final String word) {
		final StringBuilder reversed = new StringBuilder(word.toLowerCase()).reverse();
		return word.toLowerCase().contentEquals(reversed);
	}

	public String generateString(final String word) {
		if (isPalindrome(word)) {
			return word;
		}
		return word + new StringBuilder(word).reverse();
	}
}
