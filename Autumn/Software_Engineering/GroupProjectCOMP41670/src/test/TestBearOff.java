package test;

import static org.junit.Assert.*;

import model.BearOff;
import org.junit.Before;
import org.junit.Test;

public class TestBearOff {
    private BearOff bearOff;

    @Before
    public void setUp() {
        bearOff = new BearOff();
    }

    @Test
    public void testWhiteNotWin() {
        assertFalse(bearOff.whiteWon());
        assertEquals(bearOff.getWhite(), 0);
        for (int i = 0; i < 14; ++i) {
            bearOff.bearOffWhite();
        }
        assertFalse(bearOff.whiteWon());
        bearOff.bearOffWhite();
        bearOff.bearOffWhite();
        bearOff.reset();
        assertEquals(bearOff.getWhite(), 0);
    }

    @Test
    public void testRedNotWin() {
        assertFalse(bearOff.redWon());
        assertEquals(bearOff.getRed(), 0);
        for (int i = 0; i < 14; ++i) {
            bearOff.bearOffRed();
        }
        assertFalse(bearOff.redWon());
        bearOff.bearOffRed();
        bearOff.bearOffRed();
        bearOff.reset();
        assertEquals(bearOff.getRed(), 0);
    }

    @Test
    public void testWhiteWin() {
        for (int i = 0; i < 15; ++i) {
            bearOff.bearOffWhite();
        }
        assertTrue(bearOff.whiteWon());
    }

    @Test
    public void testRedWin() {
        for (int i = 0; i < 15; ++i) {
            bearOff.bearOffRed();
        }
        assertTrue(bearOff.redWon());
    }
}
