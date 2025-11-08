package test;

import adt.Pair;
import view.GameView;

import java.util.ArrayList;
import java.util.List;

/**
 * TestGameView simulates the GameView for testing purposes.
 * It captures messages and simulates user input.
 */
public class TestGameView extends GameView {

    private List<String> messages;

    public TestGameView() {
        messages = new ArrayList<>();
    }

    @Override
    public Pair<String, String> askForPlayerNames() {
        return new Pair<>("Player1", "Player2");
    }

    @Override
    public int promptForMatchLength() {
        return 3;
    }

    @Override
    public void displayMessage(String message) {
        messages.add(message);
    }

    @Override
    public String getDoubleAnswer(String currentPlayer, String player1, String player2) {
        return "accept";
    }
}
