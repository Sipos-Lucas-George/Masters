package test;

import static org.junit.Assert.*;

import model.GameTracker;
import org.junit.Before;
import org.junit.Test;

public class GameTrackerTest {

    private GameTracker gameTracker;

    @Before
    public void setUp() {
        gameTracker = new GameTracker();
    }

    @Test
    public void testIncreaseMoves() {
        // Test increasing moves
        gameTracker.increaseMoves();
        gameTracker.increaseMoves();

        // Check that the moves have been incremented correctly
        assertEquals("Score: 0\nMoves: 2\n", gameTracker.toString());
    }

    @Test
    public void testMoveCardBetweenLanesIncreasesScore() {
        // Test that moving a card between lanes increases score by 5
        gameTracker.moveCardBetweenLanes();

        // Verify the score
        assertTrue(gameTracker.toString().contains("Score: 5"));
    }

    @Test
    public void testMoveCardFromDrawPile2FoundationIncreasesScore() {
        // Test that moving a card from the draw pile to a foundation increases score by 10
        gameTracker.moveCardFromDrawPile2Foundation();

        // Verify the score
        assertEquals("Score: 10\nMoves: 1\n", gameTracker.toString());
    }

    @Test
    public void testMoveCardFromLane2FoundationIncreasesScore() {
        // Test that moving a card from a lane to a foundation increases score by 20
        gameTracker.moveCardFromLane2Foundation();

        // Verify the score
        assertTrue(gameTracker.toString().startsWith("Score: 20"));
    }

    @Test
    public void testMultipleActionsAffectScoreAndMoves() {
        // Perform multiple actions
        gameTracker.increaseMoves();                    // +1 move
        gameTracker.moveCardBetweenLanes();             // +5 score
        gameTracker.moveCardFromDrawPile2Foundation();  // +10 score
        gameTracker.increaseMoves();                    // +1 move
        gameTracker.moveCardFromLane2Foundation();      // +20 score

        // Verify the total score and moves
        assertTrue(gameTracker.toString().contains("Moves: 5"));
        assertTrue(gameTracker.toString().contains("Score: 35"));
    }

    @Test
    public void testToStringFormat() {
        // Test the string output for initial state (0 score and 0 moves)
        String output = gameTracker.toString();
        assertTrue(output.startsWith("Score: 0"));
        assertTrue(output.contains("Moves: 0"));
    }
}
