/**
 *
 */
package org.lucidant;

import java.util.Arrays;

/**
 * @author chrisfaulkner
 *
 */
public class AlternatingCase {

	public String toAlternativeString(final String input) {
		final StringBuilder alternating = new StringBuilder(input.length());
		for (String entry : Arrays.stream(input.split("")).toList())
		{
			alternating.append(isLowerCase(entry.charAt(0)) ? entry.toUpperCase() : entry.toLowerCase());
		}
		return alternating.toString();
	}

	private  boolean isLowerCase(char ch) {
	    return ch >= 'a' && ch <= 'z';
	}
}
