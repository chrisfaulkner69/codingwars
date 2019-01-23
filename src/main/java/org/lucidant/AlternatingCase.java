/**
 * 
 */
package org.lucidant;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author chrisfaulkner
 *
 */
public class AlternatingCase {

	public String toAlternativeString(final String input)
	{
		final StringBuffer alternating = new StringBuffer(input.length());
		for (String entry : Arrays.stream(input.split("")).collect(Collectors.toList()))
		{
			alternating.append(isLowerCase(entry.charAt(0)) ? entry.toUpperCase() : entry.toLowerCase());
		}
		return alternating.toString();
	}
	
	private  boolean isLowerCase(char ch) {
	    return ch >= 'a' && ch <= 'z';
	}
}
