package org.lucidant.kyu6;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MazeRunnerTest {

    private final int[][] mazeNoStart = {
        { 1, 1, 1, 1 },
        { 1, 0, 0, 3 },
        { 1, 0, 1, 0 },
        { 1, 1, 1, 0 } };

    private final int[][] mazeNoEnd = {
            { 1, 1, 1, 1 },
            { 1, 2, 0, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 1, 0 } };

    private final int[][] simpleMaze = {
            { 1, 1, 1, 1 },
            { 1, 2, 0, 3 },
            { 1, 0, 1, 0 },
            { 1, 1, 1, 0 } };

    @Test
    void givenInvalidArrayDimensions_whenWalk_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> MazeRunner.walk(null, new String[] { "E", "E" }));
        assertThrows(IllegalArgumentException.class, () -> MazeRunner.walk(new int[][] { { 1 }, { 1 } }, new String[] { "E", "E" }));
    }

    @Test
    void givenInvalidArrayDirections_whenWalk_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> MazeRunner.walk(simpleMaze, new String[] {  }));
        assertThrows(IllegalArgumentException.class, () -> MazeRunner.walk(simpleMaze, null));
    }

    @Test
    void givenNoStartOrEndPosition_whenWalk_thenFail() {
        assertThrows(IllegalArgumentException.class, () -> MazeRunner.walk(mazeNoStart, new String[] { "E", "E" }));
        assertThrows(IllegalArgumentException.class, () -> MazeRunner.walk(mazeNoEnd, new String[] { "E", "E" }));
    }

    @Test
    void givenSimpleStraightLine_whenWalkEastEast_thenFinish() {
        assertEquals("Finish", MazeRunner.walk(simpleMaze, new String[] { "E", "E" }), "Expected Finish");
        final int[][] deathMaze = {
                { 1, 1, 1, 1 },
                { 2, 0, 0, 3 },
                { 1, 0, 1, 0 },
                { 1, 1, 1, 0 } };
        assertEquals("Dead", MazeRunner.walk(deathMaze, new String[] { "E", "S", "S" }), "Expected Dead");
    }

    @Test
    void given_whenWalkEastEastSouth_thenWallAndDead() {
        final int[][] deathMaze = {
                { 1, 1, 1, 1 },
                { 2, 0, 0, 3 },
                { 1, 0, 1, 0 },
                { 1, 1, 1, 0 } };
        assertEquals("Dead", MazeRunner.walk(deathMaze, new String[] { "E", "S", "S" }), "Expected Dead");
    }

    @Test
    void given_whenWalkWestAndNorth_thenWallAndDead() {
        final int[][] deathMaze = {
                { 1, 1, 1, 1 },
                { 3, 0, 0, 2 },
                { 1, 0, 1, 0 },
                { 1, 0, 0, 2 } };
        assertEquals("Dead", MazeRunner.walk(deathMaze, new String[] { "W", "W", "N", "N", "N" }), "Expected Dead");
    }

    @Test
    void givenTooManyMoves_whenReachEndpoint_thenFinished() {
        final int[][] deathMaze = {
                { 1, 3, 1, 1 },
                { 1, 0, 0, 2 },
                { 1, 0, 1, 0 },
                { 1, 0, 0, 2 } };
        assertEquals("Finish", MazeRunner.walk(deathMaze, new String[] { "W", "W", "N", "N", "N", "N", "N", "N" }), "Expected Finish");
    }

    @Test
    void givenInternalWall_whenReachEndpoint_thenDead() {
        final int[][] deathMaze = {
                { 1, 3, 1, 1, 0 },
                { 1, 0, 0, 0, 2 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 0, 2, 0} };
        assertEquals("Dead", MazeRunner.walk(deathMaze, new String[] { "W", "W", "S" }), "Expected Dead");
    }

    @Test
    void givenLeaveMaze_whenReachEndpoint_thenDead() {
        final int[][] deathMaze = {
                { 1, 3, 1, 1, 0 },
                { 2, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 0, 2, 0} };
        assertEquals("Dead", MazeRunner.walk(deathMaze, new String[] { "E", "E", "E", "E", "E" }), "Expected Dead");
    }

    @Test
    void givenLost_whenReachEndpoint_thenLost() {
        final int[][] deathMaze = {
                { 1, 3, 1, 1, 0 },
                { 2, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0} };
        assertEquals("Lost", MazeRunner.walk(deathMaze, new String[] { "E", "S", "E", "S", "E" }), "Expected Lost");
    }

    int[][] maze = {
            { 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 0, 0, 3 },
            { 1, 0, 1, 0, 1, 0, 1 },
            { 0, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1 },
            { 1, 2, 1, 0, 1, 0, 1 } };

    @Test
    void testFromCodeWars() {
        assertEquals("Finish", MazeRunner.walk(maze, new String[] { "N", "N", "N", "N", "N", "E", "E", "E", "E", "E" }), "Expected Finish");
        assertEquals("Finish", MazeRunner.walk(maze, new String[] { "N", "N", "N", "N", "N", "E", "E", "S", "S", "E", "E", "N", "N", "E" }), "Expected Finish");
        assertEquals("Finish", MazeRunner.walk(maze, new String[] { "N", "N", "N", "N", "N", "E", "E", "E", "E", "E", "W", "W" }), "Expected Finish");

        assertEquals("Dead", MazeRunner.walk(maze, new String[] { "N", "N", "N", "W", "W" }), "Expected Dead");
        assertEquals("Dead", MazeRunner.walk(maze, new String[] { "N", "N", "N", "N", "N", "E", "E", "S", "S", "S", "S", "S", "S" }), "Expected Dead");

        assertEquals("Lost", MazeRunner.walk(maze, new String[] { "N", "E", "E", "E", "E" }), "Expected Lost");
    }

    @Nested
    class PositionTest {

        @Test
        void givenMoveEast_whenWalk_thenFinish() {
            var position = new MazeRunner.Position(2, 2);

            var pos1 = position.moveEast();
            assertEquals(3, pos1.col());
            assertEquals(2, pos1.row());
        }

        @Test
        void givenMoveWest_whenWalk_thenFinish() {
            var position = new MazeRunner.Position(2, 2);

            var pos1 = position.moveWest();
            assertEquals(1, pos1.col());
            assertEquals(2, pos1.row());
        }

        @Test
        void givenMoveSouth_whenWalk_thenFinish() {
            var position = new MazeRunner.Position(2, 2);

            var pos1 = position.moveSouth();
            assertEquals(2, pos1.col());
            assertEquals(3, pos1.row());
        }

        @Test
        void givenMoveNorth_whenWalk_thenFinish() {
            var position = new MazeRunner.Position(2, 2);

            var pos1 = position.moveNorth();
            assertEquals(2, pos1.col());
            assertEquals(1, pos1.row());

        }
    }
}
