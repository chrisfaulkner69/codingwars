package org.lucidant.interview.maze;

public enum Direction {

    NORTH("SOUTH"),
    SOUTH("NORTH"),
    EAST("WEST"),
    WEST("EAST");

    private final String opposite;

    Direction(String opposite) {
        this.opposite = opposite;
    }

    public Direction getOpposite() {
        return Direction.valueOf(opposite);
    }

    public boolean isOpposite(Direction direction) {
        return direction.equals(Direction.valueOf(opposite));
    }
}
