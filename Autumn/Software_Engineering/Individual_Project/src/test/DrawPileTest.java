package test;

import static org.junit.Assert.*;

import model.Card;
import model.Deck;
import model.DrawPile;
import org.junit.Before;
import org.junit.Test;

public class DrawPileTest {

    private DrawPile drawPile;

    @Before
    public void setUp() {
        Deck deck = new Deck();  // Initialize a new deck
        drawPile = new DrawPile(deck);  // Initialize DrawPile with the deck
    }

    @Test
    public void testDrawPileInitialization() {
        // Ensure the draw pile is correctly initialized with all cards from the deck
        for (int i = 0; i < 52; i++) {
            assertEquals(52 - i, drawPile.getSize());  // Check the size of the draw pile
            assertNotNull(drawPile.getCard());  // Ensure the first card is not null
            assertTrue(drawPile.getCard().isFaceUp());  // Ensure cards are face-up in the draw pile
            drawPile.removeCard();
        }
        assertEquals(drawPile.getSize(), 0);
    }

    @Test
    public void testGetCard() {
        // Ensure we can get the current card
        Card currentCard = drawPile.getCard();
        assertNotNull(currentCard);  // Should not be null if the draw pile is not empty
    }

    @Test
    public void testRemoveCard() {
        // Remove the current card from the draw pile
        Card firstCard = drawPile.getCard();
        drawPile.removeCard();

        // Ensure the pile size has decreased by 1
        assertEquals(51, drawPile.getSize());

        // Ensure the new current card is not the same as the first one (since it was removed)
        assertNotSame(firstCard, drawPile.getCard());
    }

    @Test
    public void testNextCard() {
        // Store the first card
        Card firstCard = drawPile.getCard();

        // Move to the next card
        drawPile.nextCard();

        // Ensure the current card is different from the first card
        Card nextCard = drawPile.getCard();
        assertNotSame(firstCard, nextCard);
    }

    @Test
    public void testNextCardWrapAround() {
        // Move to the last card manually by invoking nextCard 52 times
        Card firstCard = drawPile.getCard();
        for (int i = 0; i < 52; i++) {
            drawPile.nextCard();
        }

        assertSame(firstCard, drawPile.getCard());  // The card should wrap around to the start
    }

    @Test
    public void testRemoveCardWrapAround() {
        // Remove all cards one by one and ensure it wraps around to the first card
        for (int i = 0; i < 52; i++) {
            drawPile.removeCard();
        }

        // Ensure the draw pile is empty after all cards are drawn
        assertEquals(0, drawPile.getSize());
        assertNull(drawPile.getCard());  // No card should be returned after the draw pile is empty
    }

    @Test
    public void testToString() {
        // Check the string representation of the current card
        assertTrue(drawPile.toString().startsWith("P: "));
        assertNotNull(drawPile.getCard());
    }
}
