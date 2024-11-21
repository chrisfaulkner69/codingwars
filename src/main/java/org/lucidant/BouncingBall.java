package org.lucidant;

public class BouncingBall {

    /**
     * The provided Java code defines a method `bouncingBall` that determines the number of times a bouncing ball will pass a certain height (the window) when dropped from a given height. Here’s a detailed breakdown of how the method works:
     *
     * @param initialHeight  the initial height
     * @param bounce  the bounce factor, fraction of height reached after each bounce
     * @param window  the height of the window
     * @return
     *    number of times ball passes the window
     */
    public static int bouncingBall(double initialHeight, double bounce, double window) {
        if (isInvalidInput(initialHeight, bounce, window)) {
            return -1;
        }
        double height = initialHeight;
        int windowPassCount = -1;
        while (height > window) {
            windowPassCount += 2;
            height = bounce * height;
        }
        return windowPassCount;
    }

    private static boolean isInvalidInput(final double initialHeight, final double bounceFactor, final double windowHeight) {
        return initialHeight < 0.0d || bounceFactor < 0.0 || bounceFactor > 1.0 || windowHeight >= initialHeight;
    }
}
