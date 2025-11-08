package test;

import static org.junit.Assert.*;

import model.Dice;
import org.junit.Before;
import org.junit.Test;

import adt.Pair;

public class TestDice {
    private Dice dice;

    @Before
    public void setUp() {
        dice = new Dice();
    }

    @Test
    public void testDiceRoll() {
        int roll1 = dice.roll().first;
        int roll2 = dice.roll().second;
        assertTrue(roll1 >= 1 && roll1 <= 6 && roll2 >= 1 && roll2 <= 6);
    }

    @Test
    public void testSetDice() {
        dice.setDice(3, 5);
        Pair<Integer, Integer> result = dice.getDice();
        assertNotNull(result);
        assertEquals((Integer)3, result.first);
        assertEquals((Integer)5, result.second);
    }

    @Test
    public void testReset() {
        dice.setDice(3, 5);
        dice.reset();
        assertNull(dice.getDice());
    }
}
