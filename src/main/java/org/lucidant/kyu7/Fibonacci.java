package org.lucidant.kyu7;

/**
 * Do Fibonacci.
 */
public final class Fibonacci
{

    /**
     *
     * @param position
     * @return
     */
    public static long fib(final int position){
        if (position <= 0) {
            throw new IllegalArgumentException("Parameter must be > 0");
        }
        if (position <= 2) {
            return 1;
        }
        long currentFib = 1;
        final long[] lastTwo = new long[] {1, 1};
        for (int i = 3; i <= position; i++)
        {
            currentFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = currentFib;
        }
        return currentFib;
    }
}
