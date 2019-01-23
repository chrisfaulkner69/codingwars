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
	public static int grow(int[] x) {

//		if (x.length == 1) {
//			return x[0];
//		}
//		int runningTotal = x[0] * x[1];
//		if (x.length > 2) {
//			for (int i = 1; i < x.length-1 ; i++) {
//				runningTotal = runningTotal * x[i+1];
//			}
//		}
//		return runningTotal;
		
//		  int result=1;
//		  for(int e:x)
//		    result*=e;
//
//		    return result;
		 return IntStream.of(x).reduce(1, (a, b) -> a * b);
	}

}
