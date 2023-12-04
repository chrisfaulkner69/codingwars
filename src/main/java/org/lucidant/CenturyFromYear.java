/**
 *
 */
package org.lucidant;

/**
 * The first century spans from the year 1 up to and including the year 100, The second - from the year 101 up to and including the year 200, etc.
 *
 * @see <a href="https://www.codewars.com/kata/5a3fe3dde1ce0e8ed6000097">Source</a>
 *
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
		if(Integer.parseInt(year.substring(length - 4 + 1))%100 == 0)
		{
			return Integer.parseInt(year.substring(0, length >= 4 ? 2 : length - 2));
		}
		return Integer.parseInt(year.substring(0, length >= 4 ? 2 : length - 2)) + 1;
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
