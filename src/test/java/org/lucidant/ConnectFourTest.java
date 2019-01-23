package org.lucidant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.lucidant.ConnectFour.*;

class ConnectFourTest {

    @DisplayName("Nobody has a go, it's a draw")
    @Test
    public void testNoGoes()
    {
        assertEquals( "Draw", ConnectFour.whoIsWinner(Collections.<String>emptyList()));
    }

    @DisplayName("Yellow gets a win by a column in B")
    @Test
    public void firstTest()
    {
        final WinStatus[][] array = new WinStatus[6][7];
        array[0][COL_A] = WinStatus.RED; // A bottom position
        array[0][COL_B] = WinStatus.YELLOW;
        array[1][COL_A] = WinStatus.RED;
        array[1][COL_B] = WinStatus.YELLOW;
        array[2][COL_A] = WinStatus.RED;
        array[2][COL_B] = WinStatus.YELLOW;
        array[0][COL_G] = WinStatus.RED;
        array[3][COL_B] = WinStatus.YELLOW;
        assertEquals("Yellow", ConnectFour.determineWinner(array));
    }

//    @DisplayName("Yellow gets a win by a column in B")
//    @Test
//    public void firstTest()
//    {
//        final List<String> myList = Arrays.asList(
//                "A_Red",
//                "B_Yellow",
//                "A_Red",
//                "B_Yellow",
//                "A_Red",
//                "B_Yellow",
//                "G_Red",
//                "B_Yellow"
//        );
//        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
//    }
}