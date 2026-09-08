package org.lucidant.interview.maze;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.lucidant.interview.maze.Direction.EAST;
import static org.lucidant.interview.maze.Direction.NORTH;
import static org.lucidant.interview.maze.Direction.SOUTH;
import static org.lucidant.interview.maze.Direction.WEST;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MazeWalkerTest {

    @Mock
    private MazeService mazeService;

    @InjectMocks
    private MazeWalker mazeWalker;

    @Nested
    class MockedSolutions {
        @Test
        void givenAtExitAtStart_whenMove_thenDone() {
            when(mazeService.isAtExit()).thenReturn(Boolean.TRUE);

            List<Direction> path = mazeWalker.solve();

            assertEquals(0, path.size());

            verify(mazeService).isAtExit();
            verifyNoMoreInteractions(mazeService);
        }

        @Test
        void givenSingleDirectionSuccess_whenMove_thenDone() {
            when(mazeService.isAtExit()).thenReturn(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE);
            when(mazeService.canMove(NORTH)).thenReturn(Boolean.TRUE);

            List<Direction> path = mazeWalker.solve();

            assertEquals(1, path.size());
            assertSame(NORTH, path.getFirst());

            verify(mazeService, atLeastOnce()).isAtExit();
            verify(mazeService).canMove(NORTH);
            verify(mazeService, atLeastOnce()).move(NORTH);
        }

        @Test
        void givenAllRoutesBlocked_whenMove_thenNoSolution() {
            when(mazeService.isAtExit()).thenReturn(Boolean.FALSE);

            List<Direction> path = mazeWalker.solve();

            assertEquals(0, path.size());

            verify(mazeService).canMove(NORTH);
            verify(mazeService).canMove(SOUTH);
            verify(mazeService).canMove(EAST);
            verify(mazeService).canMove(WEST);
            verify(mazeService, never()).move(any());
        }
    }

    @Nested
    class ConcreteMazeServiceProvider {

        @Test
        void givenSingleStepToExit_whenMove_thenDone() {

            var mazeService = new GridMazeService(new String[] {
                    "#####",
                    "#E..#",
                    "#S#.#",
                    "#...#",
                    "#####"
            });

            mazeWalker = new MazeWalker(mazeService);

            List<Direction> path = mazeWalker.solve();

            assertEquals(1, path.size());
            assertSame(NORTH, path.getFirst());
        }

        @Test
        void givenBacktrackNecessary_whenMove_thenDone() {

            var mazeService = new GridMazeService(new String[] {
                    "#####",
                    "#.#.#",
                    "#S..#",
                    "#..E#",
                    "#####"
            });

            mazeWalker = new MazeWalker(mazeService);

            List<Direction> path = mazeWalker.solve();

            assertEquals(3, path.size());
            // path entries will be either 2 EAST and 1 south
            // or 1 south then 2 east
            assertEquals(EAST, path.getFirst());
        }

        @Test
        void givenStepsPossible_whenGetNextPossible_thenDone() {

            var mazeService = new GridMazeService(new String[] {
                    "#####",
                    "#.#.#",
                    "#S..#",
                    "#..E#",
                    "#####"
            });

            var mazeWalker = new MazeWalker(mazeService);

            // the last step was NORTH from bottom left
            // We can go north again or EAST
            var path = List.of(NORTH);
            List<Direction> newD = mazeWalker.getNewDirections(path);

            assertEquals(2, newD.size());
            assertSame(EAST, newD.getFirst());
            assertSame(NORTH, newD.getLast());
        }

        @Test
        void givenTwoStepsPossible_whenGetNextPossible_thenDone() {
            var mazeService = new GridMazeService(new String[]{
                    "#####",
                    "#E..#",
                    "#S#.#",
                    "#...#",
                    "#####"
            });

            mazeWalker = new MazeWalker(mazeService);

            List<Direction> path = mazeWalker.getNewDirections(Collections.emptyList());

            System.out.println(path.toString());

            assertEquals(2, path.size());
            assertSame(NORTH, path.getFirst());
            assertSame(SOUTH, path.getLast());
        }
    }

}
