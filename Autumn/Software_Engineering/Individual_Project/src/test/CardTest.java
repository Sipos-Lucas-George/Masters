package test;

import static org.junit.Assert.*;

import model.Card;
import org.junit.Test;

public class CardTest {

    @Test
    public void testCardCreation() {
        Card card = new Card('A', 'H', false);
        assertNotNull(card);
        assertEquals('A', card.getRank());
        assertEquals('H', card.getSuit());
        assertFalse(card.isFaceUp());
    }

    @Test
    public void testFaceUp() {
        Card card = new Card('A', 'H', false);
        assertFalse(card.isFaceUp());
        card.faceUp();
        assertTrue(card.isFaceUp());
    }

    @Test
    public void testToStringFaceDown() {
        Card card = new Card('A', 'H', false);
        assertEquals("XX", card.toString());  // Expect "XX" for face-down cards
    }

    @Test
    public void testToStringFaceUp() {
        Card card = new Card('A', 'H', true);
        assertEquals("A♥", card.toString());  // Expect rank and symbol for face-up cards
    }
}
