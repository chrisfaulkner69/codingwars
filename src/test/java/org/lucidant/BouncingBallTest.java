package org.lucidant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BouncingBallTest {

//    Float parameter "h" in meters must be greater than 0
//    Float parameter "bounce" must be greater than 0 and less than 1
//    Float parameter "window" must be less than h.
//

    @Test
    void testInvalidParams() {
        assertEquals(-1, BouncingBall.bouncingBall(0.0, 0.3, 1.0));
        assertEquals(-1, BouncingBall.bouncingBall(1.0, 0.3, 1.1));
        assertEquals(-1, BouncingBall.bouncingBall(2.0, 1.1, 1.0));
    }

    @Test
    void test1() {
        assertEquals(3, BouncingBall.bouncingBall(3.0, 0.66, 1.5));
    }

    @Test
    void testTinyBounce() {
        assertEquals(1, BouncingBall.bouncingBall(100.0, 0.1, 90.0));
    }

    @Test
    void testBigBounce() {
        assertEquals(43, BouncingBall.bouncingBall(100.0, 0.9, 10.0));
    }

    @Test
    public void test2() {
        assertEquals(15, BouncingBall.bouncingBall(30.0, 0.66, 1.5));
    }

}