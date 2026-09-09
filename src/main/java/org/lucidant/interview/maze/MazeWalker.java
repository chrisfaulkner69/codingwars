package org.lucidant.interview.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MazeWalker {

    public final MazeService mazeService;

    public MazeWalker(final MazeService mazeService) {
        this.mazeService = mazeService;
    }

    List<Direction> solve() {
        List<Direction> path = new ArrayList<>();
        Map<Integer, Set<Direction>> failedAtDepth = new HashMap<>();

        while (!mazeService.isAtExit()) {
            List<Direction> forwardPossibleDirections = getNewDirections(path, failedAtDepth);
            // Nowhere new to go
            if (forwardPossibleDirections.isEmpty() && !path.isEmpty()) {
                Direction failedDirection = path.getLast();
                failedAtDepth.computeIfAbsent(path.size() - 1, d -> new java.util.HashSet<>()).add(failedDirection);
                Direction undo = failedDirection.getOpposite();
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

    List<Direction> getNewDirections(List<Direction> path, Map<Integer, Set<Direction>> failedAtDepth) {

        var last = !path.isEmpty() ? path.getLast() : null;

        return Arrays.stream(Direction.values())
                .filter(d -> last == null || !d.isOpposite(last))
                .filter(d -> !failedAtDepth.getOrDefault(path.size(), Set.of()).contains(d))
                .filter(mazeService::canMove)
                .sorted(Comparator.comparing(Direction::name))
                .toList();
    }

    private void backtrack(List<Direction> path, Direction direction) {
        path.removeLast();
        mazeService.move(direction);
    }

}
