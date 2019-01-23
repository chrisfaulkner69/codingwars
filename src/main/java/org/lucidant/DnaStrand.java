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
public class DnaStrand {
	
	public static String makeComplement(final String dna) {
		return Arrays.stream(dna.split("")).map(DnaAlternative::alternative).collect(Collectors.joining());
	}
}


enum DnaAlternative
{
	A,
	T,
	C,
	G;
	
	public static String alternative(String in)
	{
		String alternative = "";
		try {
			final DnaAlternative dnaAlternative = valueOf(in);
			switch (dnaAlternative) {
			case A:
				alternative = T.toString();
				break;
			case T:
				alternative = A.toString();
				break;
			case C:
				alternative = G.toString();
				break;
			case G:
				alternative = C.toString();
				break;	
			default:
				break;
			}
		}
		catch(IllegalArgumentException ex)
		{
		}
		return alternative;
	}
}