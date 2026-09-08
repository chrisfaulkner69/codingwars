package org.lucidant.kyu6;

import java.util.Arrays;
import java.util.Optional;

public class MazeRunner {

    static final int WALL_POS = 1;
    static final int START_POS = 2;
    static final int END_POS = 3;

    public static String walk(int[][] maze, String[] directions) {

        if (maze == null || maze.length < 2 || maze[0].length < 2) {
            int xDimension = maze != null ? maze.length - 1 : 0;
            int yDimension = maze != null ? maze[0].length - 1 : 0;
            throw new IllegalArgumentException("Invalid array dimensions [" +xDimension+","+yDimension+"]");
        }

        if (directions == null || directions.length < 2) {
            throw new IllegalArgumentException("Invalid array directions ["+ Arrays.toString(directions) +"]");
        }

        final var startPos = getPositionOfValue(START_POS, maze).orElseThrow(() -> new IllegalArgumentException("No start position ["+START_POS+"]"));
        getPositionOfValue(END_POS, maze).orElseThrow(() -> new IllegalArgumentException("No end position ["+END_POS+"]"));
        final var dimension = maze.length;

        var nextPos = startPos;
        for (String direction : directions) {
            nextPos = switch (direction) {
                case "N" -> nextPos.moveNorth();
                case "E" -> nextPos.moveEast();
                case "S" -> nextPos.moveSouth();
                case "W" -> nextPos.moveWest();
                default -> nextPos;
            };
            if (isDead(nextPos, dimension, maze)) {
                return "Dead";
            }
            if (maze[nextPos.row][nextPos.col] == END_POS) {
                return "Finish";
            }
        }

        return "Lost";
    }

    private static boolean isDead(Position nextPos, int dimension, int[][] maze) {
        if (nextPos.row < 0 || nextPos.col < 0) {
            return true;
        }
        else if (nextPos.row >= dimension || nextPos.col >= dimension) {
            return true;
        }
        else return maze[nextPos.row][nextPos.col] == WALL_POS;
    }

    static Optional<Position> getPositionOfValue(int searchValue, int[][] maze) {
        int row = -1;
        int col = -1;
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == searchValue) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (row == -1) {
            return Optional.empty();
        }
        return Optional.of(new Position(row, col));
    }

    public record Position(int row, int col) {

        public Position moveEast() {
            return new Position(row, col + 1);
        }

        public Position moveWest() {
            return new Position(row, col -1);
        }

        public Position moveNorth() {
            return new Position(row - 1, col);
        }

        public Position moveSouth() {
            return new Position(row + 1 , col);
        }
    }

}
