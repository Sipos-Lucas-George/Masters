package model;

import static constants.GameConstants.SYMBOL_SUIT_MAP;

public class Card {
    private final char rank;
    private final char suit;
    private boolean isFaceUp;

    public Card(char rank, char suit, boolean isFaceUp) {
        this.rank = rank;
        this.suit = suit;
        this.isFaceUp = isFaceUp;
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void faceUp() {
        this.isFaceUp = true;
    }

    @Override
    public String toString() {
        return isFaceUp ? "" + rank + SYMBOL_SUIT_MAP.get(suit) : "XX";
    }
}
