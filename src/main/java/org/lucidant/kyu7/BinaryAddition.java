package org.lucidant.kyu7;

/**
 * Binary Addition.
 * @see <a href="https://www.codewars.com/kata/551f37452ff852b7bd000139">Source</a>
 *
 */
public class BinaryAddition {

    static String binaryAddition(int a, int b){
        final int sum = a + b;
        return Integer.toBinaryString(sum);
    }
}
