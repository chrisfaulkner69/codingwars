/**
 * 
 */
package org.lucidant;

/**
 * @author chrisfaulkner
 *
 */
public class FizzBuzz {
	
	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	
	public void doFizzBuzz(final int startNum, final int endNum) {
		
		for (int i = startNum ; i<= endNum ; i++ )
		{
			final boolean isDivThree = i%3 == 0;
			final boolean isDivFive = i%5 == 0;
			
			final StringBuilder sb = new StringBuilder(10);
			if (!isDivThree && !isDivFive)
			{
				sb.append(i);
			}
			else
			{
				if (isDivThree)
				{
					sb.append(FIZZ);
				}
				if (isDivFive)
				{
					sb.append(BUZZ);
				}
			}
			System.out.println(sb);
		}
	}
	
	static String numberToString(final int numIn)
	{
		return String.valueOf(numIn);
	}

}
