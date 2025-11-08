package test;

import static org.junit.Assert.*;

import model.Board;
import model.Checker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class TestBoard {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testInitializeBoard() {
        ArrayList<Checker>[] points = board.getPoints();

        // Validate initial positions
        assertEquals(2, points[1].size());
        assertEquals(5, points[6].size());
        assertEquals(3, points[8].size());
        assertEquals(5, points[12].size());
        assertEquals(5, points[13].size());
        assertEquals(3, points[17].size());
        assertEquals(5, points[19].size());
        assertEquals(2, points[24].size());

        // Check colors
        assertEquals("R", points[1].get(0).color());
        assertEquals("W", points[24].get(0).color());
    }

    @Test
    public void testResetBoard() {
        // Modify the board state
        board.getPoints()[1].clear();
        board.resetBoard();

        testInitializeBoard();
    }

    @Test
    public void testCalculatePipCounts() {
        Map<Integer, Integer> redPipCounts = board.calculatePipCounts("R");
        Map<Integer, Integer> whitePipCounts = board.calculatePipCounts("W");

        assertEquals(167, (int) redPipCounts.get(0));
        assertEquals(167, (int) whitePipCounts.get(0));

        assertEquals(48, (int) redPipCounts.get(1));
        assertEquals(48, (int) whitePipCounts.get(24));
        assertEquals(65, (int) redPipCounts.get(12));
        assertEquals(24, (int) whitePipCounts.get(8));
    }

    @Test
    public void testMakeMoveBar() {
        board.getPoints()[25].add(new Checker("W"));

        board.makeMove(null, "BAR", "4", "W");

        ArrayList<Checker>[] points = board.getPoints();

        assertEquals(0, points[25].size());
        assertEquals(1, points[4].size());
        assertEquals("W", points[4].get(0).color());
    }
}
