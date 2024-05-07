package org.lucidant.kyu7;

public class BinaryAddition {

    static String binaryAddition(int a, int b){
        final int sum = a + b;
        return Integer.toBinaryString(sum);
    }
}
