package test;

import static org.junit.Assert.*;

import model.Checker;
import org.junit.Before;
import org.junit.Test;

public class TestChecker {
    private Checker checker;

    @Before
    public void setUp() {
        checker = new Checker("R");
    }

    @Test
    public void testCheckerColor() {
        assertEquals(checker.toString(), "R");
    }
}
