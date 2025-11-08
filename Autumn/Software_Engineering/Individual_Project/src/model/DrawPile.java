package model;

public class DrawPile extends CardsPile {
    private int currentCard = 0;

    public DrawPile(Deck deck) {
        while (!deck.isEmpty()) {   // put the remaining cards into the draw pile
            Card card = deck.getCard();
            card.faceUp();
            cards.add(card);
        }
    }

    public Card getCard() {
        return (cards.isEmpty()) ? null : cards.get(currentCard);
    }

    public void removeCard() {
        cards.remove(currentCard);
        if (currentCard >= cards.size()) {  // cycle the cards
            currentCard = 0;
        }
    }

    public void nextCard() {
        if (currentCard < cards.size() - 1) {
            ++currentCard;
        } else {
            currentCard = 0;    // cycle the cards
        }
    }

    @Override
    public String toString() {
        return "P: " + ((cards.isEmpty()) ? "" : cards.get(currentCard));
    }
}
