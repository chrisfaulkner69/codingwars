package org.lucidant.interview.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MazeWalker {

    public final MazeService mazeService;

    public MazeWalker(final MazeService mazeService) {
        this.mazeService = mazeService;
    }

    List<Direction> solve() {
        if (mazeService.isAtExit()) {
            return Collections.emptyList();
        }

        List<Direction> path = new ArrayList<>();

        // Nowhere to go but backtrack
        while (!mazeService.isAtExit()) {
            List<Direction> forwardPossibleDirections = getNewDirections(path);
            // Nowhere new to go
            if (forwardPossibleDirections.isEmpty() && !path.isEmpty()) {
                Direction undo = path.getLast().getOpposite();
                backtrack(path, undo);
                System.out.println("[Backtrack] Moved direction: " + undo);
            } else if (!forwardPossibleDirections.isEmpty()) {

                Direction nextStep = getNextStep(forwardPossibleDirections);

                mazeService.move(nextStep);
                path.add(nextStep);
                System.out.println("Moved direction: " + nextStep);
            } else {
                // No candidates left, and nothing to backtrack out of: fully exhausted, no solution.
                break;
            }
        }
        return path;
    }

    private Direction getNextStep(List<Direction> forwardPossibleDirections) {
        for (Direction candidate : forwardPossibleDirections) {
            mazeService.move(candidate);
            if (mazeService.isAtExit()) {
                mazeService.move(candidate.getOpposite());
                return candidate; // or whatever "we found it" looks like for your return type
            }
            mazeService.move(candidate.getOpposite());
        }
        return forwardPossibleDirections.getFirst();
    }

    List<Direction> getNewDirections(List<Direction> path) {

        var last = !path.isEmpty() ? path.getLast() : null;

        return Arrays.stream(Direction.values())
                .filter(d -> last == null || !d.isOpposite(last))
                .filter(mazeService::canMove)
                .sorted(Comparator.comparing(Direction::name))
                .toList();
    }

    private void backtrack(List<Direction> path, Direction direction) {
        path.removeLast();
        mazeService.move(direction);
    }

}
