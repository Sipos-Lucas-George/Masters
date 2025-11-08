package test;

import static org.junit.Assert.*;

import model.DoublingCube;
import org.junit.Before;
import org.junit.Test;

public class TestDoublingCube {
    private DoublingCube doublingCube;

    @Before
    public void setUp() {
        doublingCube = new DoublingCube();
    }

    @Test
    public void testInitalValue() {
        assertEquals(1, doublingCube.getValue());
    }

    @Test
    public void testInitialOwner() {
        assertEquals("neutral", doublingCube.getOwner());
    }

    @Test
    public void testDoubleCube() {
        doublingCube.doubleCube("player1", "player1", "player2");
        assertEquals(2, doublingCube.getValue());
        assertEquals("player2", doublingCube.getOwner());
        doublingCube.doubleCube("player2", "player1", "player2");
        assertEquals(4, doublingCube.getValue());
        assertEquals("player1", doublingCube.getOwner());
    }

    @Test
    public void testCanDoubleNeutral() {
        assertTrue(doublingCube.canDouble("player1"));
    }

    @Test
    public void testCanDoublePlayer1() {
        doublingCube.doubleCube("player2", "player1", "player2");
        assertTrue(doublingCube.canDouble("player1"));
    }

    @Test
    public void testCanDoublePlayer2() {
        doublingCube.doubleCube("player1", "player1", "player2");
        assertTrue(doublingCube.canDouble("player2"));
    }

    @Test
    public void testReset() {
        doublingCube.doubleCube("player1", "player1", "player2");
        doublingCube.reset();
        assertEquals(1, doublingCube.getValue());
        assertEquals("neutral", doublingCube.getOwner());
    }
}
