package model;

import ADT.Pair;

import java.util.ArrayList;
import java.util.Collections;

import static constants.GameConstants.NEXT_RANK_MAP;
import static constants.GameConstants.SUITS_MAP;

public class Lane extends CardsPile {

    public Lane(int number, Deck deck) {
        while (0 < number--) {  // add the number of cards corresponding to their lane number
            cards.add(deck.getCard());
        }
        cards.getLast().faceUp();   // face up the top card
    }

    public Card getCard(int index) {
        return (index < cards.size()) ? cards.get(index) : null;
    }

    public Pair<Card, Integer> getCard(Card cardParent) {
        if (cards.isEmpty()) {
            return new Pair<>(null, null);
        }
        for (int i = 0; i < cards.size(); i++) {
            Card temp = cards.get(i);
            if (!temp.isFaceUp()) { // if !faced up, doesn't matter
                continue;
            }
            if (cardParent == null && temp.getRank() == 'K') {  // there is no bigger card than 'K'
                return new Pair<>(temp, i);
            } else if (cardParent != null && temp.getRank() != 'K'
                    && SUITS_MAP.get(temp.getSuit()) % 2 != SUITS_MAP.get(cardParent.getSuit()) % 2
                    && NEXT_RANK_MAP.get(temp.getRank()) == cardParent.getRank()) { // opposite suits and smaller rank
                return new Pair<>(temp, i);
            }
        }
        return new Pair<>(null, null);
    }

    public void removeCard() {
        if (!this.cards.isEmpty()) {
            cards.removeLast();
            if (!this.cards.isEmpty()) {    // if cards !empty maybe last card is not faced up
                cards.getLast().faceUp();
            }
        }
    }

    public ArrayList<Card> removeCards(int numberOfCards) {
        numberOfCards = Math.min(numberOfCards, cards.size());  // if it's bigger than the size, pick the size
        ArrayList<Card> removedCards = new ArrayList<>();
        while (numberOfCards > 0) {
            removedCards.add(cards.removeLast());
            --numberOfCards;
        }
        if (!cards.isEmpty()) {
            cards.getLast().faceUp();
        }
        Collections.reverse(removedCards);  // reverse it into the correct formation
        return removedCards;
    }
}
