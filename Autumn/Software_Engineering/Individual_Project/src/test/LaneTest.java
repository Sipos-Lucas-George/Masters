package test;

import ADT.Pair;
import static org.junit.Assert.*;

import model.Card;
import model.Deck;
import model.Lane;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LaneTest {

    private Deck deck;
    private Lane lane;

    @Before
    public void setUp() {
        deck = new Deck();
        lane = new Lane(3, deck);  // Creates a lane with 3 cards from the deck
    }

    @Test
    public void testLaneInitialization() {
        // Check that the correct number of cards are added to the lane
        assertEquals(3, lane.getSize());

        // The last card should be face up
        assertTrue(lane.getCard(2).isFaceUp());

        // The first two cards should be face down
        assertFalse(lane.getCard(0).isFaceUp());
        assertFalse(lane.getCard(1).isFaceUp());
    }

    @Test
    public void testGetCardByIndex() {
        // Ensure the card at index 0 is accessible
        Card cardAtIndex0 = lane.getCard(0);
        assertNotNull(cardAtIndex0);

        // Ensure that getting a card beyond the current size returns null
        assertNull(lane.getCard(10));
    }

    @Test
    public void testGetKingWhenNoParentCard() {
        // Set up a card with rank 'K' in the lane and test retrieval
        Card kingCard = new Card('K', 'S', true);
        lane.addCard(kingCard);  // Add King card to the lane

        Pair<Card, Integer> result = lane.getCard(null);

        assertNotNull(result);
        assertEquals(kingCard, result.getFirst());
        assertEquals((Integer) 3, result.getSecond());  // King is now the 4th card in lane
    }

    @Test
    public void testGetMatchingCardForParent() {
        // Add a parent card (e.g., a Queen of a different color)
        Card parentCard = new Card('Q', 'H', true); // Red queen
        lane.addCard(new Card('J', 'S', true)); // Black Jack to match

        Pair<Card, Integer> result = lane.getCard(parentCard);

        assertNotNull(result);
        assertEquals('J', result.getFirst().getRank());
        assertEquals('S', result.getFirst().getSuit());
    }

    @Test
    public void testGetCardNoMatch() {
        // Test with no matching card
        Card parentCard = new Card('5', 'S', true);
        Pair<Card, Integer> result = lane.getCard(parentCard);

        // No match found
        assertNull(result.getFirst());
        assertNull(result.getSecond());
    }

    @Test
    public void testRemoveCards() {
        // Remove 2 cards from the lane
        ArrayList<Card> removedCards = lane.removeCards(2);

        // Ensure that 2 cards were removed
        assertEquals(2, removedCards.size());

        // Ensure the lane has 1 card remaining
        assertEquals(1, lane.getSize());

        // The remaining card should be face up
        assertTrue(lane.getCard(0).isFaceUp());
    }

    @Test
    public void testRemoveMoreCardsThanPresent() {
        // Attempt to remove more cards than are in the lane
        ArrayList<Card> removedCards = lane.removeCards(5);

        // All cards should be removed
        assertEquals(3, removedCards.size());

        // The lane should now be empty
        assertEquals(0, lane.getSize());
    }
}
