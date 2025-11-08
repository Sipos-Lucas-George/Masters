package model;

import java.util.Collections;
import java.util.LinkedList;

import static constants.GameConstants.RANKS;
import static constants.GameConstants.SUITS;

public class Deck {
    private LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();

        for (char suit : SUITS) {
            for (char rank : RANKS) {
                cards.add(new Card(rank, suit, false));
            }
        }
        Collections.shuffle(cards);
    }

    public Card getCard() {
        return (!cards.isEmpty()) ? cards.pop() : null;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
