package org.lucidant;

import java.util.Arrays;
import java.util.List;

import static org.lucidant.WinStatus.DRAW;

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
        final WinStatus[][] arr = storeMoves(myList, ROW_COUNT, COL_COUNT);
        return determineWinner(arr);
    }

    static String determineWinner(final WinStatus[][] arr) {

        WinStatus winner = DRAW;
        for (int i = 0; i< COL_COUNT ; i++) {
            WinStatus current = arr[CO]
        }
        return DRAW.toString();
    }

    static WinStatus[][] storeMoves(final List<String> myList, final int cols, final int rows) {

        final WinStatus[][] board = new WinStatus[cols][rows];
        return board;
    }

}

enum WinStatus {

    DRAW("Draw"),
    RED("Draw"),
    YELLOW("Draw");

    private final String value;

    WinStatus(final String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
