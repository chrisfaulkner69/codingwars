/**
 * 
 */
package org.lucidant;

import java.util.StringTokenizer;

/**
 * @author chrisfaulkner
 *
 */
public class WordSpinner {
	
	public String spinWords(final String input)
	{
		if (input == null || input.trim().isEmpty())
		{
			return "";
		}
		
//	      return Arrays.stream( sentence.split(" ") )
//                  .map( w -> w.length() < 5 ? w : new StringBuilder(w).reverse().toString() )
//                  .collect(Collectors.joining(" "));
		
//	      return Arrays.stream(new StringTokenizer(input, " ")
//	    		  .stream()
//	    		  .map(word -> word.length() < 5 ? w : new StringBuilder(w).reverse().toString())
//	    		  .collect(Collectors.joining(" "));
	      
		final StringTokenizer tokens = new StringTokenizer(input, " ");
		final StringBuilder result = new StringBuilder(input.length());
		while (tokens.hasMoreTokens())
		{
			final String token  = tokens.nextToken();
			if(token.trim().length() >= 5)
			{
				result.append(new StringBuilder(token).reverse()).append(' ');
			}
			else
			{
				result.append(token).append(' ');
			}
		}
		
		return result.toString().trim();
	}

}
