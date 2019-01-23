/**
 * 
 */
package org.lucidant;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chrisfaulkner
 *
 */
public class MinNumberNotInArray {
	
	private static final int MAX = 100000;
	
    public int solution(final int[] A) {
    	
    	int num = 1;
    	
    	if (A == null || A.length <= 0)
    	{
    		return num;
    	}
    	
    	// Make a Set, sort and filter out all less than or equal to 0
    	final Set<Integer> list = Arrays.stream(A).boxed().filter(element -> element.intValue() > 0).sorted().collect(Collectors.toSet());
    	
    	System.out.println("Post clean " + list.toString());
    	
    	// List must have been entirely numbers less than equal to 0
    	if (!list.isEmpty())
    	{
	    	for (int i = 1; i < MAX; i++) {
				if (!list.contains(Integer.valueOf(i)))
				{
					num = i;
					break;
				}
			}
    	}
    	
    	return num;
    }
}
