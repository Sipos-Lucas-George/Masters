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
        for (int i = 0; i < 14; ++i) {
            bearOff.bearOffWhite();
        }
        assertFalse(bearOff.whiteWon());
    }

    @Test
    public void testRedNotWin() {
        assertFalse(bearOff.redWon());
        for (int i = 0; i < 14; ++i) {
            bearOff.bearOffRed();
        }
        assertFalse(bearOff.redWon());
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
