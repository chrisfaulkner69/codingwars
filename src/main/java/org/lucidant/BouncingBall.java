package org.lucidant;

public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        if (h < 0.0d || bounce <0.0 || bounce > 1.0 || window >= h) {
            return -1;
        }
        int windowPassCount = -1;
        while (h > window) {
            windowPassCount += 2;
            h = bounce * h;
        }
        return windowPassCount;
    }
}
