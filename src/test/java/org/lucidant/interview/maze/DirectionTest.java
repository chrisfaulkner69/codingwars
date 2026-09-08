package org.lucidant.interview.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void isNorthOppositeTo() {
        assertTrue(Direction.NORTH.isOpposite(Direction.SOUTH));
        assertFalse(Direction.NORTH.isOpposite(Direction.WEST));
        assertFalse(Direction.NORTH.isOpposite(Direction.EAST));
    }

}
