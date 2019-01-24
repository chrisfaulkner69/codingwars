package org.lucidant.kyu4;

import java.util.Arrays;
import java.util.List;

import static org.lucidant.kyu4.WinStatus.DRAW;

// https://www.codewars.com/kata/connect-four-1
public class ConnectFour {

    private static final String SEPARATOR = "_";
    private static final int ROW_COUNT = 6;
    static final List<String> COL_NAMES = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
    private static final int COL_COUNT = COL_NAMES.size();

    public static String whoIsWinner(final List<String> myList) {

        // Not enough moves to decide a winner
        if (myList == null || myList.isEmpty() || myList.size() < 7) {
            return DRAW.toString();
        }

        //
        return whoWins(myList).toString();
    }

    private static WinStatus whoWins(final List<String> myList) {

        final WinStatus[][] board = new WinStatus[ROW_COUNT][COL_COUNT];
         // We have A_Red, B_Yellow as the identifiers
        for (final String move : myList) {
            final String[] res = move.split(SEPARATOR);
            final WinStatus counter =  WinStatus.valueOf(res[1].toUpperCase());
            final String colName = res[0];
            if (addAndCheckForWinner(board, colName.toUpperCase(), counter)) {
                return counter;
            }
        }
        return WinStatus.DRAW;
    }

    private static boolean addAndCheckForWinner(final WinStatus[][] board, final String colName, final WinStatus piece) {

        final int colNum = COL_NAMES.indexOf(colName);

        // Looking for the first empty row for the column, then add
        for (int row = 0 ; row < ROW_COUNT ; row++) {
            if (board[row][colNum] == null) {
                System.out.println("Added " + piece.toString() + " to row : " + row + " and col :" + colNum);
                board[row][colNum] = piece;
                return checkWinner(board, row, colNum, piece);
            }
        }
        return false;
    }

    private static boolean checkWinner(final WinStatus[][] board, final int row, final int colNum, final WinStatus piece) {

        // Row to the right
        if (checkRow(board, colNum, row, piece)) {
            return true;
        }

        if (checkDiagonal(board, colNum, row, piece)) {
            return true;
        }

        // column check - only need to check down
        final int targetRowBelow = row - 3;
        if (targetRowBelow < 0) {
            return false;
        }
        for (int i = row ; i >= targetRowBelow ; i--) {
            if (board[i][colNum] != piece) {
                return false;
            }
        }
        return true;

    }

    private static boolean checkDiagonal(WinStatus[][] board, int colNum, int row, WinStatus piece) {
        int consecutiveNorWstSthEasr = 0;
        int consecutiveNorEastSthWest = 0;


    }

    private static boolean checkRow(final WinStatus[][] board, final int startCol, final int row, final WinStatus piece) {

        int consecutiveToRight = 0;
        int consecutiveToLeft = 0;
        for (int colNum = startCol + 1 ; colNum <= COL_COUNT - 1 ; colNum++) {
            if (board[row][colNum] != piece) {
                break;
            }
            consecutiveToRight++;
        }

        for (int colNum = startCol - 1; colNum >= 0 ; colNum--) {
            if (board[row][colNum] != piece) {
                break;
            }
            consecutiveToLeft++;
        }

        return  (consecutiveToRight + consecutiveToLeft + 1) >= 4;
    }

}

enum WinStatus {

    DRAW("Draw"),
    RED("Red"),
    YELLOW("Yellow");

    private final String value;

    WinStatus(final String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
