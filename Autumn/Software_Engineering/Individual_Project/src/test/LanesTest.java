package test;

import static constants.GameConstants.NUMBER_OF_LANES;
import static org.junit.Assert.*;

import ADT.Pair;
import model.Card;
import model.Deck;
import model.Lanes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LanesTest {

    private Deck deck;
    private Lanes lanes;

    @Before
    public void setUp() {
        deck = new Deck();
        lanes = new Lanes(deck);
    }

    @Test
    public void testLaneInitialization() {
        // Test if each lane is initialized with the correct number of cards
        for (int i = 0; i < NUMBER_OF_LANES; i++) {
            assertEquals(i + 1, lanes.getLaneSize(i));  // First lane has 1 card, second has 2, etc.
        }
    }

    @Test
    public void testGetCardFromLane() {
        // Test getting the last card from a lane
        Card card = lanes.getCard(0);  // Get the last card from the first lane
        assertNotNull(card);  // Ensure it's not null

        // Test getting a specific card by index
        Card cardAtIndex1 = lanes.getCard(1, 1);  // Get the 2nd card from the 2nd lane
        assertNotNull(cardAtIndex1);
    }

    @Test
    public void testGetCardByParentCard() {
        // Add a King to a lane and test retrieval with no parent card
        Card kingCard = new Card('K', 'S', true);
        lanes.addCard(kingCard, 0);  // Add King to lane 0

        Pair<Card, Integer> result = lanes.getCard(0, null);  // Get the King card
        assertEquals(kingCard, result.getFirst());
    }

    @Test
    public void testAddCardToLane() {
        // Add a card to lane 0 and check the size
        Card card = new Card('5', 'S', true);
        int initialSize = lanes.getLaneSize(0);

        lanes.addCard(card, 0);

        // Ensure the size increased and the card was added
        assertEquals(initialSize + 1, lanes.getLaneSize(0));
        assertEquals(card, lanes.getCard(0));  // Last card should be the newly added card
    }

    @Test
    public void testAddCardsToLane() {
        // Add multiple cards to lane 1
        ArrayList<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(new Card('5', 'S', true));
        cardsToAdd.add(new Card('6', 'H', true));

        int initialSize = lanes.getLaneSize(1);
        lanes.addCards(cardsToAdd, 1);

        // Ensure the size increased by the number of cards added
        assertEquals(initialSize + 2, lanes.getLaneSize(1));
    }

    @Test
    public void testRemoveCardFromLane() {
        // Test removing the last card from a lane
        int initialSize = lanes.getLaneSize(0);
        lanes.removeCard(0);

        // Ensure the size decreases by 1
        assertEquals(initialSize - 1, lanes.getLaneSize(0));
    }

    @Test
    public void testRemoveMultipleCards() {
        // Test removing multiple cards from a lane
        int initialSize = lanes.getLaneSize(1);

        ArrayList<Card> removedCards = lanes.removeCards(1, 2);  // Remove 2 cards from lane 1

        // Ensure the size decreases by 2
        assertEquals(initialSize - 2, lanes.getLaneSize(1));

        // Ensure the correct number of cards were removed
        assertEquals(2, removedCards.size());
    }

    @Test
    public void testRemoveMoreCardsThanPresent() {
        // Attempt to remove more cards than are present in lane 0
        int initialSize = lanes.getLaneSize(0);

        ArrayList<Card> removedCards = lanes.removeCards(0, initialSize + 1);

        // Ensure all cards were removed and the lane is empty
        assertEquals(initialSize, removedCards.size());
        assertEquals(0, lanes.getLaneSize(0));
    }

    @Test
    public void testToStringFormat() {
        // Check if the string representation of lanes has the expected format
        String lanesString = lanes.toString();

        // Check if the string contains expected lane headers (numbers 1 to NUMBER_OF_LANES)
        for (int i = 1; i <= NUMBER_OF_LANES; i++) {
            assertTrue(lanesString.contains(String.valueOf(i)));
        }

        // Ensure there's no runtime error and output is as expected
        assertNotNull(lanesString);
    }
}
