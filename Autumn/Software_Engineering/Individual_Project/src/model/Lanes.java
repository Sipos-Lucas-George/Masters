package model;

import ADT.Pair;

import java.util.ArrayList;

import static constants.GameConstants.NUMBER_OF_LANES;

public class Lanes {
    private Lane[] lanes;

    public Lanes(Deck deck) {
        lanes = new Lane[NUMBER_OF_LANES];

        for (int i = 0; i < NUMBER_OF_LANES; i++) {
            lanes[i] = new Lane(i + 1, deck);
        }
    }

    public int getLaneSize(int laneIndex) {
        return lanes[laneIndex].getSize();
    }

    public Card getCard(int laneIndex) {
        if (lanes[laneIndex].getSize() == 0) {
            return null;
        }
        return lanes[laneIndex].getCard(lanes[laneIndex].getSize() - 1);
    }

    public Card getCard(int laneIndex, int cardIndex) {
        return lanes[laneIndex].getCard(cardIndex);
    }

    public Pair<Card, Integer> getCard(int laneIndex, Card cardParent) {
        return lanes[laneIndex].getCard(cardParent);
    }

    public void addCard(Card card, int index) {
        lanes[index].addCard(card);
    }

    public void addCards(ArrayList<Card> cards, int index) {
        lanes[index].addCards(cards);
    }

    public void removeCard(int index) {
        lanes[index].removeCard();
    }

    public ArrayList<Card> removeCards(int laneIndex, int numberOfCards) {
        return lanes[laneIndex].removeCards(numberOfCards);
    }

    @Override
    public String toString() {
        final int TEXT_FORMAT_OFFSET = 10;
        final String BLANK_SPACES = "          ";
        int maxColumnSize = lanes[0].getSize();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lanes.length; i++) {
            StringBuilder stringBuilderNumbers = new StringBuilder();
            stringBuilderNumbers.append(i + 1).append(BLANK_SPACES);
            result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
        }
        result.append("\n");

        for (int i = 0; i < lanes.length; i++) {
            result.append("-".repeat(TEXT_FORMAT_OFFSET));
        }
        result.append("\n");

        for (int i = 1; i < lanes.length; i++) {
            maxColumnSize = Math.max(maxColumnSize, lanes[i].getSize());
        }
        for (int i = 0; i < maxColumnSize; i++) {
            for (Lane lane : lanes) {
                StringBuilder stringBuilderCards = new StringBuilder();
                stringBuilderCards.append((lane.getCard(i) == null) ? "" : lane.getCard(i)).append(BLANK_SPACES);
                result.append(stringBuilderCards, 0, TEXT_FORMAT_OFFSET);
            }
            result.append("\n");
        }

        return result.toString();
    }
}
