import org.example.Cell;
import org.example.GameOfLife;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeTest {
    @Test
    void testEmptyConstructor() {
        new GameOfLife(3, new ArrayList<Cell>());
    }

    @Test
    void testEmptyCurrentGeneration() {
        GameOfLife game = new GameOfLife(3, new ArrayList<>());
        assertTrue(game.currentGeneration().isEmpty());
    }

    @Test
    void testEmptyNextGeneration() {
        GameOfLife game = new GameOfLife(3, new ArrayList<>());
        assertTrue(game.nextGeneration().currentGeneration().isEmpty());
    }

    @Test
    void testSingleCellNextGeneration() {
        GameOfLife game = new GameOfLife(3, List.of(new Cell(1, 2)));
        assertTrue(game.nextGeneration().currentGeneration().isEmpty());
    }

    @Test
    void testRule3NextGeneration() {
        GameOfLife game = new GameOfLife(3, List.of(
                new Cell(1, 2),
                new Cell(1, 1),
                new Cell(2, 1),
                new Cell(2, 2)));
        assertEquals(game, game.nextGeneration());
    }

    @Test
    void testRule2NextGeneration() {
        List<Cell> liveCells = new ArrayList<>(List.of(
                new Cell(1, 1),
                new Cell(0, 1),
                new Cell(1, 0),
                new Cell(2, 2)));

        GameOfLife game = new GameOfLife(3, liveCells);

        List<Cell> newCells = new ArrayList<>(List.of(
                new Cell(1, 1),
                new Cell(0, 1),
                new Cell(1, 0),
                new Cell(1, 2),
                new Cell(2, 1),
                new Cell(0, 0)));

        assertEquals(new GameOfLife(3, newCells), game.nextGeneration());
    }

    @Test
    void testImmutability() {
        List<Cell> liveCells = new ArrayList<>();
        GameOfLife game = new GameOfLife(3, liveCells);
        liveCells.add(new Cell(0, 0));
        assertNotEquals(liveCells, game.currentGeneration());
    }

    @Test
    void testOutOfGridCells() {
        List<Cell> liveCells = new ArrayList<>(List.of(
                new Cell(3, 3),
                new Cell(3, 4),
                new Cell(4, 3),
                new Cell(4, 4)));

        GameOfLife game = new GameOfLife(2, liveCells);
        assertTrue(game.nextGeneration().currentGeneration().isEmpty());
    }

    @Test
    void testBlockPatternStability() {
        // Block pattern (2x2 still life)
        List<Cell> liveCells = List.of(
                new Cell(1, 1),
                new Cell(1, 2),
                new Cell(2, 1),
                new Cell(2, 2));

        GameOfLife game = new GameOfLife(4, liveCells);
        assertEquals(game, game.nextGeneration());
    }

    @Test
    void testBlinkerOscillator() {
        // Blinker pattern (oscillator)
        List<Cell> verticalBlinker = List.of(
                new Cell(1, 0),
                new Cell(1, 1),
                new Cell(1, 2));

        GameOfLife game = new GameOfLife(5, verticalBlinker);

        // Horizontal blinker after one generation
        List<Cell> horizontalBlinker = List.of(
                new Cell(0, 1),
                new Cell(1, 1),
                new Cell(2, 1));

        assertEquals(new GameOfLife(5, horizontalBlinker), game.nextGeneration());
    }

    @Test
    void testGliderPattern() {
        // Glider moving diagonally
        List<Cell> glider = List.of(
                new Cell(0, 2),
                new Cell(1, 1),
                new Cell(2, 1),
                new Cell(2, 2),
                new Cell(2, 3));

        GameOfLife game = new GameOfLife(5, glider);

        GameOfLife newGame = game
                .nextGeneration()
                .nextGeneration()
                .nextGeneration()
                .nextGeneration();

        List<Cell> newList = glider.stream()
                .map(c -> new Cell(c.getX() + 1, c.getY() - 1))
                .toList();

        assertEquals(new GameOfLife(5, newList), newGame);
    }

    @Test
    void testEdgeWrappingDoesNotOccur() {
        // Cells near the edge should not wrap around
        List<Cell> liveCells = List.of(
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(1, 0));

        GameOfLife game = new GameOfLife(3, liveCells);

        // After one generation, only (0,0) should remain since it has 2 neighbors
        List<Cell> expectedNextGen = List.of(
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(1, 0),
                new Cell(1, 1));

        assertEquals(new GameOfLife(3, expectedNextGen), game.nextGeneration());
    }

    @Test
    void testCellDiesDueToOverpopulation() {
        // A cell with more than 3 neighbors should die
        List<Cell> liveCells = List.of(
                new Cell(1, 1),
                new Cell(0, 1),
                new Cell(1, 0),
                new Cell(2, 1),
                new Cell(1, 2));

        GameOfLife game = new GameOfLife(3, liveCells);

        assertFalse(game.nextGeneration().currentGeneration().contains(new Cell(1, 1)));
    }

    @Test
    void testDeadCellBecomesAlive() {
        // Dead cell at (1,1) has exactly 3 neighbors, should become alive
        List<Cell> liveCells = List.of(
                new Cell(0, 1),
                new Cell(1, 0),
                new Cell(2, 1));

        GameOfLife game = new GameOfLife(3, liveCells);

        // (1,1) should be born in the next generation
        assertTrue(game.nextGeneration().currentGeneration().contains(new Cell(1, 1)));
    }

    @Test
    void testNextGenerationRemovesOutOfBoundsCells() {
        // Add cells, some of which are out of bounds
        List<Cell> liveCells = List.of(
                new Cell(-1, 0),
                new Cell(0, -1),
                new Cell(0, 0),
                new Cell(3, 3));

        GameOfLife game = new GameOfLife(3, liveCells);

        // out-of-bounds cells should be both ignored as neighbours and removed from the
        // next generation
        assertEquals(new GameOfLife(3, new ArrayList<>()), game.nextGeneration());
    }

    /**
     * A 2x2 block in the center of a 4x4 grid is a well-known
     * stable configuration (it never changes).
     */
    @Test
    void testBlockRemainsStable() {
        List<Cell> block = List.of(
                new Cell(1, 1),
                new Cell(1, 2),
                new Cell(2, 1),
                new Cell(2, 2));
        GameOfLife game = new GameOfLife(4, block);

        GameOfLife next = game.nextGeneration();
        assertEquals(game, next, "A 2x2 block should remain unchanged in the next generation.");
    }

    /**
     * Tests the classic "blinker" oscillator in a 5x5 grid.
     * It alternates between a horizontal line of three cells
     * and a vertical line of three cells.
     */
    @Test
    void testBlinkerOscillation() {
        // Horizontal blinker in row 2 (indices are zero-based).
        List<Cell> blinker = List.of(
                new Cell(2, 1),
                new Cell(2, 2),
                new Cell(2, 3));
        GameOfLife game = new GameOfLife(5, blinker);

        // First next generation should be vertical
        GameOfLife next = game.nextGeneration();
        List<Cell> expectedVertical = List.of(
                new Cell(1, 2),
                new Cell(2, 2),
                new Cell(3, 2));
        assertEquals(new GameOfLife(5, expectedVertical), next,
                "After one generation, the blinker should be vertical.");

        // Second next generation should revert to horizontal
        GameOfLife next2 = next.nextGeneration();
        assertEquals(game, next2,
                "After two generations, the blinker should return to the original horizontal state.");
    }

    /**
     * Tests that two GameOfLife instances with the same grid size
     * and the same live cells (even if the cells are in a different order)
     * are considered equal.
     */
    @Test
    void testEqualitySameConfigurations() {
        List<Cell> cells = List.of(
                new Cell(0, 0),
                new Cell(1, 1));
        // Note: Constructed with the same cells but possibly in a different order
        GameOfLife game1 = new GameOfLife(3, cells);
        GameOfLife game2 = new GameOfLife(3, new ArrayList<>(cells));

        assertEquals(game1, game2,
                "Two games with identical live cells and grid size should be equal.");
    }

    /**
     * Tests that two GameOfLife instances with different grid sizes
     * are not considered equal, even if they have the same live cell positions.
     */
    @Test
    void testEqualityDifferentGridSizes() {
        List<Cell> cells = List.of(
                new Cell(0, 0),
                new Cell(1, 1));
        GameOfLife game1 = new GameOfLife(3, cells);
        GameOfLife game2 = new GameOfLife(4, cells);

        assertNotEquals(game1, game2,
                "Two games with different grid sizes should not be equal.");
    }

    /**
     * Tests that two GameOfLife instances with the same grid size
     * but different live cell positions are not considered equal.
     */
    @Test
    void testEqualityDifferentCells() {
        List<Cell> cells1 = List.of(
                new Cell(0, 0),
                new Cell(1, 1));
        List<Cell> cells2 = List.of(
                new Cell(0, 0),
                new Cell(2, 2));
        GameOfLife game1 = new GameOfLife(3, cells1);
        GameOfLife game2 = new GameOfLife(3, cells2);

        assertNotEquals(game1, game2,
                "Two games with different sets of live cells should not be equal.");
    }

    /**
     * (Optional) This test checks how cells on the boundary behave.
     * A lone cell on the corner should die off. If it has enough
     * neighbors, it might survive. Adjust the test to fit
     * your own logic or examples.
     */
    @Test
    void testBoundaryCellBehavior() {
        // Single cell in the top-left corner
        List<Cell> cells = List.of(new Cell(0, 0));
        GameOfLife game = new GameOfLife(3, cells);

        // A single corner cell should die in the next generation (no neighbors)
        GameOfLife next = game.nextGeneration();
        assertTrue(next.currentGeneration().isEmpty(),
                "A single cell on the boundary with no neighbors should die.");
    }


    @Test
    void testBoundaries() {
        List<Cell> cells1 = List.of(
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(0, 2),
                new Cell(1, 2),
                new Cell(1, 0),
                new Cell(2, 0),
                new Cell(2, 1),
                new Cell(2, 2));
        List<Cell> cells2 = List.of(
                new Cell(0, 0),
                new Cell(0, 2),
                new Cell(2, 0),
                new Cell(2, 2));
        GameOfLife game = new GameOfLife(3, cells1);
        assertEquals(new GameOfLife(3, new ArrayList<>(cells2)), game.nextGeneration());
    }
}