package model;

import java.util.Stack;

import static constants.GameConstants.NEXT_RANK_MAP;
import static constants.GameConstants.NUMBER_OF_RANKS;

public class Foundation {
    private Stack<Card> foundationCards;

    public Foundation() {
        foundationCards = new Stack<>();
    }

    public Card getCard() {
        return foundationCards.empty() ? null : foundationCards.peek();
    }

    public void addCard(Card card) {
        if (foundationCards.empty() && card.getRank() == 'A') {
            foundationCards.push(card);
        } else if (!foundationCards.empty() && NEXT_RANK_MAP.get(foundationCards.peek().getRank()) == card.getRank()
                && foundationCards.peek().getSuit() == card.getSuit()) {    // only add the card with same suit and next rank
            foundationCards.push(card);
        }
    }

    public void removeCard() {
        if (!foundationCards.empty()) {
            foundationCards.pop();
        }
    }

    public boolean isComplete() {
        return foundationCards.size() == NUMBER_OF_RANKS;
    }

    @Override
    public String toString() {
        return foundationCards.toString();
    }
}
