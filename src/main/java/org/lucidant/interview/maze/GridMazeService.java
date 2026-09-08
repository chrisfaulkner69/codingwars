package org.lucidant.interview.maze;

public class GridMazeService implements MazeService {

    private final char[][] grid;
    private int row;
    private int col;

    public GridMazeService(String[] rows) {
        this.grid = new char[rows.length][];
        for (int r = 0; r < rows.length; r++) {
            grid[r] = rows[r].toCharArray();
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 'S') {
                    row = r;
                    col = c;
                }
            }
        }
    }

    @Override
    public boolean canMove(Direction direction) {
        int[] delta = delta(direction);
        int newRow = row + delta[0];
        int newCol = col + delta[1];
        return isInBounds(newRow, newCol) && grid[newRow][newCol] != '#';
    }

    @Override
    public void move(Direction direction) {
        if (!canMove(direction)) {
            throw new IllegalStateException("Cannot move " + direction + " from (" + row + "," + col + ")");
        }
        int[] delta = delta(direction);
        row += delta[0];
        col += delta[1];
    }

    @Override
    public boolean isAtExit() {
        return grid[row][col] == 'E';
    }

    private boolean isInBounds(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[r].length;
    }

    private int[] delta(Direction direction) {
        return switch (direction) {
            case NORTH -> new int[]{-1, 0};
            case SOUTH -> new int[]{1, 0};
            case EAST -> new int[]{0, 1};
            case WEST -> new int[]{0, -1};
        };
    }
}
