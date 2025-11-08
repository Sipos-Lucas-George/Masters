package test;

import static org.junit.Assert.*;

import model.Card;
import model.Foundation;
import org.junit.Before;
import org.junit.Test;

public class FoundationTest {

    private Foundation foundation;
    private Card aceOfSpades;
    private Card twoOfSpades;
    private Card kingOfSpades;

    @Before
    public void setUp() {
        foundation = new Foundation();

        aceOfSpades = new Card('A', 'S', true);
        twoOfSpades = new Card('2', 'S', true);
        kingOfSpades = new Card('K', 'S', true);
    }

    @Test
    public void testAddCardAceAsFirstCard() {
        // Add the Ace of Spades as the first card in an empty foundation
        foundation.addCard(aceOfSpades);

        // The foundation should now have the Ace of Spades on top
        assertEquals(aceOfSpades, foundation.getCard());
    }

    @Test
    public void testAddCardInCorrectSequence() {
        // Add the Ace of Spades first
        foundation.addCard(aceOfSpades);

        // Now add the Two of Spades (correct sequence after Ace)
        foundation.addCard(twoOfSpades);

        // The foundation should now have the Two of Spades on top
        assertEquals(twoOfSpades, foundation.getCard());
    }

    @Test
    public void testAddCardInIncorrectSequence() {
        // Try adding the Two of Spades without adding Ace first
        foundation.addCard(twoOfSpades);

        // The Two of Spades should not be added to the foundation (since it requires an Ace first)
        assertNull(foundation.getCard());  // No card should be in the foundation
    }

    @Test
    public void testAddCardWithDifferentSuit() {
        // Add the Ace of Spades first
        foundation.addCard(aceOfSpades);

        // Try adding a Two of a different suit (e.g., Hearts)
        Card twoOfHearts = new Card('2', 'H', true);
        foundation.addCard(twoOfHearts);

        // The foundation should still have only the Ace of Spades, as the suit doesn't match
        assertEquals(aceOfSpades, foundation.getCard());
    }

    @Test
    public void testRemoveCard() {
        // Add the Ace and Two of Spades
        foundation.addCard(aceOfSpades);
        foundation.addCard(twoOfSpades);

        // Now remove the top card (Two of Spades)
        foundation.removeCard();

        // The foundation should now have the Ace of Spades on top
        assertEquals(aceOfSpades, foundation.getCard());
    }

    @Test
    public void testRemoveCardFromEmptyFoundation() {
        // Try to remove a card from an empty foundation (should handle gracefully)
        foundation.removeCard();

        // The foundation should still be empty
        assertNull(foundation.getCard());
    }

    @Test
    public void testIsComplete() {
        // Add all 13 cards to the foundation to simulate completion
        foundation.addCard(aceOfSpades);
        foundation.addCard(new Card('2', 'S', true));
        foundation.addCard(new Card('3', 'S', true));
        foundation.addCard(new Card('4', 'S', true));
        foundation.addCard(new Card('5', 'S', true));
        foundation.addCard(new Card('6', 'S', true));
        foundation.addCard(new Card('7', 'S', true));
        foundation.addCard(new Card('8', 'S', true));
        foundation.addCard(new Card('9', 'S', true));
        foundation.addCard(new Card('T', 'S', true));
        foundation.addCard(new Card('J', 'S', true));
        foundation.addCard(new Card('Q', 'S', true));
        foundation.addCard(kingOfSpades);

        // The foundation should now be complete
        assertTrue(foundation.isComplete());
    }

    @Test
    public void testIsNotComplete() {
        // Add only the Ace of Spades
        foundation.addCard(aceOfSpades);

        // The foundation should not be complete with just one card
        assertFalse(foundation.isComplete());
    }

    @Test
    public void testToString() {
        // Add a card to the foundation
        foundation.addCard(aceOfSpades);

        // Ensure the string representation is as expected
        assertTrue(foundation.toString().contains("A"));
    }
}
