/**
 * 
 */
package org.lucidant;

/**
 * @author chrisfaulkner
 *
 */
public class CenturyFromYear {

	public static int century(final int yearAD)
	{
		if (yearAD <= 100)
		{
			return 1;
		}
		final String year = String.valueOf(yearAD);
		int length = year.length();
		if( Integer.valueOf(year.substring(length - 4 + 1))%100 == 0)
		{
			return Integer.valueOf(year.substring(0, length >= 4 ? 2 : length - 2));
		}
		return Integer.valueOf(year.substring(0, length >= 4 ? 2 : length - 2)) + 1;
	}
	
	public static int centuryLimited(final int yearAD)
	{
		if (yearAD <= 100)
		{
			return 1;
		}
		final String year = String.valueOf(yearAD);
		if(Integer.valueOf(year.substring(1))%100 == 0)
		{
			return Integer.valueOf(year.substring(0, 2));
		}
		return Integer.valueOf(year.substring(0, 2)) + 1;
	}
}
