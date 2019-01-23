package org.lucidant;

public class MultiplesSummation {

	public int solution(int number) {

		int sum = 0;
		if (number < 3)
		{
			return sum;
		}
		while (number > 2)
		{
			number--;
			if (number%3 == 0 || number%5 == 0)
			{
				sum = sum + number;

			}
		}

//	    return IntStream.range(0, number)
//                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
//                .sum();
		return sum;
	}
}
