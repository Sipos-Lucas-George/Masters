package test;

import static org.junit.Assert.*;

import model.Deck;
import model.Card;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testDeckSizeAfterInitialization() {
        // A standard deck should have 52 cards (13 ranks * 4 suits)
        int expectedSize = 52;
        int actualSize = 0;

        // Draw all cards and count them to ensure there are 52 cards
        while (!deck.isEmpty()) {
            deck.getCard();
            actualSize++;
        }

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testDeckIsNotEmptyInitially() {
        // The deck should not be empty after initialization
        assertFalse(deck.isEmpty());
    }

    @Test
    public void testGetCardRemovesCardFromDeck() {
        // Draw a card
        Card drawnCard = deck.getCard();

        // The size should now be one less than the initial size
        assertEquals(51, countRemainingCards(deck));
        assertNotNull(drawnCard);  // The drawn card should not be null
    }

    @Test
    public void testGetCardFromEmptyDeck() {
        // Draw all cards from the deck to make it empty
        while (!deck.isEmpty()) {
            deck.getCard();
        }

        // The deck is now empty, so drawing a card should return null
        assertTrue(deck.isEmpty());
        assertNull(deck.getCard());
    }

    @Test
    public void testCardsAreShuffled() {
        Deck anotherDeck = new Deck();  // Create a second deck to compare order

        // It is unlikely (though possible) that two shuffled decks have the same order,
        // so let's draw cards from both decks and compare their rank and suit.
        boolean areEqual = true;
        for (int i = 0; i < 52; i++) {
            Card cardFromFirstDeck = deck.getCard();
            Card cardFromSecondDeck = anotherDeck.getCard();

            // Compare cards' ranks and suits
            if (cardFromFirstDeck.getRank() != cardFromSecondDeck.getRank() ||
                    cardFromFirstDeck.getSuit() != cardFromSecondDeck.getSuit()) {
                areEqual = false;
                break;
            }
        }

        assertFalse(areEqual);  // Assert that the decks are not in the same order
    }

    // Helper function to count the remaining cards in the deck
    private int countRemainingCards(Deck deck) {
        int count = 0;
        while (!deck.isEmpty()) {
            deck.getCard();
            count++;
        }
        return count;
    }
}
