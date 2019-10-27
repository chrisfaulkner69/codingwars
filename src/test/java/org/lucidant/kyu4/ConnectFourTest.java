package org.lucidant.kyu4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConnectFourTest {

    @DisplayName("Nobody has a go, it's a draw")
    @Test
    void testNoGoes() {
        Assertions.assertEquals("Draw", ConnectFour.whoIsWinner(Collections.emptyList()));
    }

    @DisplayName("Yellow gets a win by a column in B")
    @Test
    void yellowUnInterruptedInColB() {
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
    void redOnRowAYellowCopyingAbove() {
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
    void redOnRowAYellowCopyingAboveButRedNotSequential() {
        final List<String> myList = Arrays.asList(
                "C_Red",
                "A_Yellow",
                "F_Red",
                "G_Yellow",
                "E_Red",
                "G_Yellow",
                "D_Red"
        );
        assertEquals("Red", ConnectFour.whoIsWinner(myList));
    }

    @DisplayName("Red wins on row 0, does so ending in G.")
    @Test
    void redOnRowEndInG() {
        final List<String> myList = Arrays.asList(
                "D_Red",
                "C_Yellow",
                "E_Red",
                "D_Yellow",
                "G_Red",
                "E_Yellow",
                "F_Red"
        );
        assertEquals("Red", ConnectFour.whoIsWinner(myList));
    }

    @DisplayName("Yellow wins with a diagonal to north east. A0, B1, C2 and D3.")
    @Test
    void boardDiagonalYellowFromOrigin() {
        final List<String> myList = Arrays.asList(
                "A_Yellow", "B_Red", "B_Yellow", "C_Red",
                "G_Yellow", "C_Red", "C_Yellow", "D_Red",
                "E_Yellow", "D_Red", "D_Yellow", "G_Red",
                "D_Yellow"
        );
        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
    }

    @DisplayName("Red wins with a diagonal to north west. G0, F1, E2, D3")
    @Test
    void boardDiagonalFromOrigin() {
        final List<String> myList = Arrays.asList(
                "G_Red " , // G0
                " F_Yellow", // F0
                "F_Red", // F1
                "D_Yellow", // D0
                "D_Red", // D1
                "D_Yellow", // D2
                "D_Red",  // D3
                "C_Yellow", // C0
                "E_Red", // E0
                "E_Yellow", // E1
                "E_Red" // E2
        );
        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
    }

//    @Disabled
    @DisplayName("Board is full with no winner.")
    @Test
    void boardFullNoWinner() {
        final List<String> myList = Arrays.asList(
                "A_Red", "G_Yellow", "B_Red", "F_Yellow", "E_Red", "C_Yellow", "D_Red",
                "A_Yellow", "G_Red", "B_Yellow", "F_Red", "G_Yellow", "A_Red",
                "D_Yellow", "C_Red", "E_Yellow", "D_Red", "E_Yellow", "G_Red",

                "C_Yellow", "F_Red", "B_Yellow", "F_Red", "E_Yellow", "A_Red",

                "F_Yellow", "B_Red", "D_Yellow", "F_Red", "A_Yellow", "A_Red",

                "A_Yellow", "B_Red", "C_Yellow", "D_Red", "E_Yellow", "D_Red"
        );
        assertEquals("Draw", ConnectFour.whoIsWinner(myList));
    }
}