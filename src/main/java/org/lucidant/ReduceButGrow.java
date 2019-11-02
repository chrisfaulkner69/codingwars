/**
 *
 */
package org.lucidant;

import java.util.stream.IntStream;

/**
 * @author chrisfaulkner
 *
 */
public class ReduceButGrow {


	public static int growSimple(int[] x){
		int result = 1;
		for (int a : x) {
			result *= a;
		}
		return result;
	}

	public static int grow(int[] x) {
		 return IntStream.of(x).reduce(1, (a, b) -> a * b);
	}

}
