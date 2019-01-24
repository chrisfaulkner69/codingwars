package org.lucidant.kyu4;

import java.util.Arrays;
import java.util.List;

import static org.lucidant.kyu4.WinStatus.DRAW;

public class ConnectFour {

    private static final int ROW_COUNT = 6;
    static final List<String> COL_NAMES = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
    private static final int COL_COUNT = COL_NAMES.size();

    static int COL_A = COL_NAMES.indexOf("A");
    static int COL_B = COL_NAMES.indexOf("B");
    static int COL_C = COL_NAMES.indexOf("C");
    static int COL_D = COL_NAMES.indexOf("D");
    static int COL_E = COL_NAMES.indexOf("E");
    static int COL_F = COL_NAMES.indexOf("F");
    static int COL_G = COL_NAMES.indexOf("G");

    public static String whoIsWinner(final List<String> myList) {

        // Not enough moves to decide a winner
        if (myList.isEmpty() || myList == null || myList.size() < 7) {
            return DRAW.toString();
        }

        //
        return storeMoves(myList, ROW_COUNT, COL_COUNT).toString();
    }


    static WinStatus storeMoves(final List<String> myList, final int cols, final int rows) {

        final WinStatus[][] board = new WinStatus[cols][rows];
         // We have A_Red, B_Yellow as the identifiers
        for (String move : myList) {
            String[] res = move.split("_");
            final WinStatus counter =  WinStatus.valueOf(res[1].toUpperCase());
            if (addToBoard(board, res[0], counter)) {
                return counter;
            }
        }
        return WinStatus.DRAW;
    }

    private static boolean addToBoard(WinStatus[][] board, String colName, WinStatus piece) {

        final int colNum = COL_NAMES.indexOf(colName);

        // Looking for the first empty row for the column, then add
        for (int row = 0 ; row< ROW_COUNT ; row++) {
            if (board[row][colNum] == null) {
                System.out.println("Added " + piece.toString() + " to row : " + row + " and col :" + colNum);
                board[row][colNum] = piece;
                return checkWinner(board, row, colNum, piece);
            }
        }
        return false;
    }

    private static boolean checkWinner(WinStatus[][] board, int row, int colNum, WinStatus piece) {


        // Row to the right
        int targetColToRight = colNum + 3;
        int targetColToLeft = colNum - 3;
        if (checkRow(board, targetColToLeft, colNum, row, piece)) {
            return true;
        }
        if (checkRow(board, colNum, targetColToRight, row, piece)) {
            return true;
        }

        // column check
        int targetRowBelow = row - 3;
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

    private static boolean checkRow(WinStatus[][] board, int leftCol, int rightCol, int row, WinStatus piece) {

        if (leftCol < 0 || rightCol > (COL_COUNT - 1)) {
            return false;
        }

        for (int colNum = leftCol ; colNum <= rightCol ; colNum++) {
            if (board[row][colNum] != piece) {
                return false;
            }
        }
        return true;
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
