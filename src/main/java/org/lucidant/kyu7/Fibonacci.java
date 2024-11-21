package org.lucidant.kyu7;

/**
 * Do Fibonacci.
 *
 * @see <a href="https://www.codewars.com/kata/57a1d5ef7cb1f3db590002af">Source</a>
 */
public final class Fibonacci {

    public static long fibRecursive (int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n -2);
    }

    public static long fib(final int position) {
        if (position <= 0) {
            throw new IllegalArgumentException("Parameter must be > 0");
        }
        if (position <= 2) {
            return 1;
        }
        long currentFib = 1;
        final long[] lastTwo = new long[]{1, 1};
        for (int i = 3; i <= position; i++) {
            currentFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = currentFib;
        }
        return currentFib;
    }
}
