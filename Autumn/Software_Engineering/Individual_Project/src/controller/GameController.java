package controller;

import ADT.Pair;
import model.*;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import static constants.GameConstants.*;

public class GameController {
    private final GameTracker gameTracker;
    private final DrawPile drawPile;
    private final Lanes lanes;
    private final Foundations foundations;
    private final ConsoleView consoleView;
    private final Scanner scanner;

    public GameController(Deck deck) {
        gameTracker = new GameTracker();
        lanes = new Lanes(deck);
        drawPile = new DrawPile(deck);
        foundations = new Foundations();
        consoleView = new ConsoleView();
        scanner = new Scanner(System.in);
    }

    public void run() {
        consoleView.displayRules();
        while (!isGameOver()) {
            consoleView.displayGame(gameTracker, drawPile, lanes, foundations);
            consoleView.displayRequestCommand();
            String command = scanner.nextLine().trim().toUpperCase();

            if (command.equals("Q")) {
                break;
            } else if (command.equals("R")) {
                consoleView.displayRules();
            } else if (command.equals("D")) {
                drawPile.nextCard();
                gameTracker.increaseMoves();
            } else if (Pattern.compile(COMMAND_REGEX).matcher(command).find()) {
                try2MakeMove(command.charAt(0), command.charAt(1),
                        (command.length() == 2) ? 0 : Integer.parseInt(command.substring(2)));
            } else {
                consoleView.displayInvalidCommandError();
            }
        }

        if (isGameOver()) {
            consoleView.displayGame(gameTracker, drawPile, lanes, foundations);
            consoleView.displayGameWon();
        } else {
            consoleView.displayGameLost();
        }
    }

    private boolean isGameOver() {
        return foundations.isGameOver();
    }

    private void try2MakeMove(char from, char to, int offset) {
        Card toCard = (SUITS.contains(to)) ? foundations.getCard(to) : lanes.getCard(Character.getNumericValue(to) - 1);
        if (SUITS.contains(from)) { /* from foundation to lane */
            if (tryMoveFromFoundation(toCard, to, from)) {
                return;
            }
        } else if (from == 'P') { /* from draw to foundation/lane */
            if (tryMoveFromDraw(toCard, to)) {
                return;
            }
        } else { /* from lane to foundation/lane */
            if (tryMoveFromLane(toCard, to, from, offset)) {
                return;
            }
        }
        consoleView.displayInvalidMoveError();
    }

    private boolean tryMoveFromFoundation(Card toCard, char to, char from) {
        Card fromCard = foundations.getCard(from);
        if (verifyCard2LaneCompatibility(fromCard, toCard)) {
            foundations.removeCard(from);
            lanes.addCard(fromCard, Character.getNumericValue(to) - 1);
            return true;
        }
        return false;
    }

    private boolean tryMoveFromDraw(Card toCard, char to) {
        Card fromCard = drawPile.getCard();
        if (SUITS.contains(to) && verifyCard2FoundationCompatibility(fromCard, toCard, to)) {   /* d to f */
            drawPile.removeCard();
            foundations.addCard(fromCard);
            gameTracker.moveCardFromDrawPile2Foundation();
            return true;
        } else if (verifyCard2LaneCompatibility(fromCard, toCard)) {    /* d to l */
            drawPile.removeCard();
            lanes.addCard(fromCard, Character.getNumericValue(to) - 1);
            gameTracker.moveCardBetweenLanes();
            return true;
        }
        return false;
    }

    private boolean tryMoveFromLane(Card toCard, char to, char from, int offset) {
        Card fromCard;
        if (SUITS.contains(to)) {   /* l to f */
            fromCard = lanes.getCard(Character.getNumericValue(from) - 1);
            if (verifyCard2FoundationCompatibility(fromCard, toCard, to)) {
                lanes.removeCard(Character.getNumericValue(from) - 1);
                foundations.addCard(fromCard);
                gameTracker.moveCardFromLane2Foundation();
                return true;
            }
        } else if (offset != 0) {   /* l to l with offset */
            fromCard = lanes.getCard(Character.getNumericValue(from) - 1,
                    lanes.getLaneSize(Character.getNumericValue(from) - 1) - offset);
            if (verifyCard2LaneCompatibility(fromCard, toCard)) {
                ArrayList<Card> fromCards = lanes.removeCards(Character.getNumericValue(from) - 1, offset);
                lanes.addCards(fromCards, Character.getNumericValue(to) - 1);
                gameTracker.moveCardBetweenLanes();
                return true;
            }
        } else {    /* l to l automated */
            Pair<Card, Integer> fromCardDetails = lanes.getCard(Character.getNumericValue(from) - 1, toCard);
            fromCard = fromCardDetails.getFirst();
            if (verifyCard2LaneCompatibility(fromCard, toCard)) {
                ArrayList<Card> fromCards = lanes.removeCards(Character.getNumericValue(from) - 1,
                        lanes.getLaneSize(Character.getNumericValue(from) - 1) - fromCardDetails.getSecond());
                lanes.addCards(fromCards, Character.getNumericValue(to) - 1);
                gameTracker.moveCardBetweenLanes();
                return true;
            }
        }
        return false;
    }

    private boolean verifyCard2LaneCompatibility(Card fromCard, Card toCard) {
        if (fromCard != null && toCard == null && fromCard.getRank() == 'K') {
            return true;
        } else if (fromCard != null && toCard != null
                && SUITS_MAP.get(fromCard.getSuit()) % 2 != SUITS_MAP.get(toCard.getSuit()) % 2
                && NEXT_RANK_MAP.get(fromCard.getRank()) == toCard.getRank()) {
            return true;
        }
        return false;
    }

    private boolean verifyCard2FoundationCompatibility(Card fromCard, Card toCard, char foundationSuit) {
        if (fromCard != null && fromCard.getSuit() != foundationSuit) {
            return false;
        }
        if (fromCard != null && toCard == null && fromCard.getRank() == 'A') {
            return true;
        } else if (fromCard != null && toCard != null && NEXT_RANK_MAP.get(toCard.getRank()) == fromCard.getRank()) {
            return true;
        }
        return false;
    }
}