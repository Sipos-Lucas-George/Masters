package test;

import static org.junit.Assert.*;

import controller.GameController;
import org.junit.Before;
import org.junit.Test;


public class TestGameController {

    private GameController controller;
    private TestGameView testView;

    @Before
    public void setUp() {
        testView = new TestGameView();
        controller = new GameController(testView);
    }

    @Test
    public void testInitialization() {
        // Validate initial setup
        assertEquals("Player1", controller.player1);
        assertEquals("Player2", controller.player2);
        assertEquals(3, GameController.matchLength);
        assertEquals(0, controller.player1Score);
        assertEquals(0, controller.player2Score);
    }

    @Test
    public void testDetermineStartingPlayer() {
        controller.dice.setDice(6, 4);
        String startingPlayer = controller.determineStartingPlayer("Player1", "Player2");

        assertEquals(("Player1".equals(startingPlayer)) ? "Player1" : "Player2", startingPlayer);
    }


    @Test
    public void testDoubleFunctionality_Accept() {
        controller.doublingCube.setOwner("Player1");
        boolean result = controller.doubleFunctionality("Player1");

        assertTrue(result);
        assertEquals(2, controller.doublingCube.getValue());
    }

}
