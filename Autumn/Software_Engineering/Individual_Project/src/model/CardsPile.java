package model;

import java.util.ArrayList;

public abstract class CardsPile {
    protected ArrayList<Card> cards;

    public CardsPile() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    public abstract void removeCard();

    public int getSize() {
        return cards.size();
    }
}
