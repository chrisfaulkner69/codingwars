package org.lucidant.kyu4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.lucidant.kyu4.ConnectFour.*;

class ConnectFourTest {

    @DisplayName("Nobody has a go, it's a draw")
    @Test
    public void testNoGoes()
    {
        Assertions.assertEquals( "Draw", ConnectFour.whoIsWinner(Collections.<String>emptyList()));
    }

    @DisplayName("Yellow gets a win by a column in B")
    @Test
    public void yellowUnInterruptedInColB()
    {
        final List<String> myList = Arrays.asList(
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "G_Red",
                "B_Yellow"
        );
        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
    }

    @DisplayName("Red wins on row 0, between C and F sequentially")
    @Test
    public void redOnRowAYellowCopyingAbove()
    {
        final List<String> myList = Arrays.asList(
                "C_Red",
                "C_Yellow",
                "D_Red",
                "D_Yellow",
                "E_Red",
                "E_Yellow",
                "F_Red"
        );
        assertEquals("Red", ConnectFour.whoIsWinner(myList));
    }

    @DisplayName("Red wins on row 0, between C and F but does C then F then E then D")
    @Test
    public void redOnRowAYellowCopyingAboveButRedNotSequential()
    {
        final List<String> myList = Arrays.asList(
                "C_Red",
                "C_Yellow",
                "F_Red",
                "D_Yellow",
                "E_Red",
                "E_Yellow",
                "D_Red"
        );
        assertEquals("Red", ConnectFour.whoIsWinner(myList));
    }
}