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
public class Isogram {

    public static boolean isIsogram(final String str) {
       if (str == null || str.trim().isEmpty())
       {
    	   return true;
       }
       
       if (!str.matches("[a-zA-Z]+"))
       {
    	   throw new IllegalArgumentException("Parameter should contain only letters.");
       }
       
       final String lower = str.toLowerCase();
       final int originalLength = lower.length();
       if (originalLength > 26)
       {
    	   return false;
       }
       
       return originalLength ==  Arrays.stream(lower.split("")).collect(Collectors.toSet()).size();
    } 
    
}