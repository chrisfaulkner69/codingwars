package org.lucidant.interview.maze;

public interface MazeService {

    boolean canMove(Direction direction);

    void move(Direction direction);

    boolean isAtExit();
}
