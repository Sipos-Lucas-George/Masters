package model;

import static constants.GameConstants.*;

public class Foundations {
    private static Foundation[] foundations;

    public Foundations() {
        foundations = new Foundation[NUMBER_OF_FOUNDATIONS];

        for (int i = 0; i < NUMBER_OF_FOUNDATIONS; i++) {
            foundations[i] = new Foundation();
        }
    }

    public void addCard(Card card) {
        foundations[SUITS_MAP.get(card.getSuit())].addCard(card);   // add the card on its corresponding suit
    }

    public Card getCard(char suit) {
        return foundations[SUITS_MAP.get(suit)].getCard();  // get the card from its corresponding suit
    }

    public void removeCard(char suit) {
        foundations[SUITS_MAP.get(suit)].removeCard();  // remove the card from its corresponding suit
    }

    public boolean isGameOver() {
        boolean isGameOver = true;
        for (Foundation foundation : foundations) { // game over (true) if all foundations are completed
            isGameOver = isGameOver && foundation.isComplete();
        }
        return isGameOver;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (char suit : SUITS) {
            result.append(suit).append(SYMBOL_SUIT_MAP.get(suit)).append(": ").append(foundations[SUITS_MAP.get(suit)].toString());
            if (foundations[SUITS_MAP.get(suit)].isComplete()) {
                result.append(" ✔");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
