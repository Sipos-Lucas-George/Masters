package test;

import static org.junit.Assert.*;

import model.Card;
import constants.GameConstants;
import model.Foundations;
import org.junit.Before;
import org.junit.Test;

public class FoundationsTest {

    private Foundations foundations;
    private Card aceOfSpades;
    private Card twoOfSpades;
    private Card aceOfHearts;

    @Before
    public void setUp() {
        foundations = new Foundations();

        aceOfSpades = new Card('A', 'S', true);
        twoOfSpades = new Card('2', 'S', true);
        aceOfHearts = new Card('A', 'H', true);
    }

    @Test
    public void testAddCardToCorrectFoundation() {
        // Add Ace of Spades to the foundations
        foundations.addCard(aceOfSpades);

        // Ensure the foundation for Spades contains the Ace of Spades
        assertEquals(aceOfSpades, foundations.getCard('S'));
    }

    @Test
    public void testAddCardInCorrectSequence() {
        // Add Ace of Spades first
        foundations.addCard(aceOfSpades);

        // Now add Two of Spades (correct sequence)
        foundations.addCard(twoOfSpades);

        // Ensure the foundation for Spades has the Two of Spades on top
        assertEquals(twoOfSpades, foundations.getCard('S'));
    }

    @Test
    public void testAddCardToDifferentSuit() {
        // Add Ace of Spades to the Spades foundation
        foundations.addCard(aceOfSpades);

        // Add Ace of Hearts to the Hearts foundation
        foundations.addCard(aceOfHearts);

        // Ensure that both foundations have their respective cards
        assertEquals(aceOfSpades, foundations.getCard('S'));
        assertEquals(aceOfHearts, foundations.getCard('H'));
    }

    @Test
    public void testRemoveCardFromFoundation() {
        // Add Ace and Two of Spades
        foundations.addCard(aceOfSpades);
        foundations.addCard(twoOfSpades);

        // Remove the top card (Two of Spades) from the Spades foundation
        foundations.removeCard('S');

        // Ensure the Ace of Spades is now on top
        assertEquals(aceOfSpades, foundations.getCard('S'));
    }

    @Test
    public void testRemoveCardFromEmptyFoundation() {
        // Try to remove a card from an empty foundation (Hearts)
        foundations.removeCard('H');

        // The foundation should still be empty
        assertNull(foundations.getCard('H'));
    }

    @Test
    public void testIsGameOver() {
        // Add cards to all foundations in order to complete them (13 cards each)
        for (char rank : GameConstants.RANKS) {
            foundations.addCard(new Card(rank, 'S', true));
            foundations.addCard(new Card(rank, 'H', true));
            foundations.addCard(new Card(rank, 'D', true));
            foundations.addCard(new Card(rank, 'C', true));
        }

        // The game should be considered over when all foundations are complete
        assertTrue(foundations.isGameOver());
    }

    @Test
    public void testIsGameNotOver() {
        // Add only a few cards to different foundations
        foundations.addCard(aceOfSpades);
        foundations.addCard(aceOfHearts);

        // The game should not be over yet since not all foundations are complete
        assertFalse(foundations.isGameOver());
    }

    @Test
    public void testToString() {
        // Add a couple of cards to foundations
        foundations.addCard(aceOfSpades);
        foundations.addCard(aceOfHearts);

        // Check the string representation of foundations
        String result = foundations.toString();

        // Ensure both suits are represented correctly
        assertTrue(result.contains("S"));
        assertTrue(result.contains("H"));
        assertTrue(result.contains("A"));  // Ace of Spades and Ace of Hearts should be displayed
    }
}
