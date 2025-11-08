package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GameOfLife {
    private final int gridSize;
    private final Set<Cell> liveCells;

    public GameOfLife(int gridSize, List<Cell> liveCells) {
        this.gridSize = gridSize;
        this.liveCells = new HashSet<>(liveCells.stream()
                .filter(c -> isWithinBounds(c))
                .toList());
    }

    public List<Cell> currentGeneration() {
        return List.copyOf(liveCells);
    }

    private int countAliveNeighbors(Cell cell) {
        return Math.toIntExact(liveCells.stream()
                .filter(other -> !other.equals(cell))
                .filter(other -> areNeighbours(cell, other))
                .count());
    }

    private boolean areNeighbours(Cell a, Cell b) {
        return Math.abs(a.getX() - b.getX()) <= 1 && Math.abs(a.getY() - b.getY()) <= 1;
    }

    public GameOfLife nextGeneration() {
        Set<Cell> nextGenCells = new HashSet<>(liveCells.stream()
                .filter(c -> {
                    int aliveNeighbors = countAliveNeighbors(c);
                    return aliveNeighbors > 1 && aliveNeighbors < 4;
                })
                .toList());

        for (int i = 0; isWithinAxis(i); i++) {
            for (int j = 0; isWithinAxis(j); j++) {
                Cell cell = new Cell(i, j);
                if (isWithinBounds(cell) && countAliveNeighbors(cell) == 3) {
                    nextGenCells.add(cell);
                }
            }
        }

        return new GameOfLife(gridSize, List.copyOf(nextGenCells));
    }

    private boolean isWithinAxis(int n) {
        return n >= 0 && n < gridSize;
    }

    private boolean isWithinBounds(Cell cell) {
        return isWithinAxis(cell.getX()) && isWithinAxis(cell.getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GameOfLife other = (GameOfLife) obj;
        if (gridSize != other.gridSize)
            return false;
        return this.liveCells.equals(other.liveCells);
    }

    @Override
    public String toString() {
        return currentGeneration().toString();
    }
}
