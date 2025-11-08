package view;

import java.util.*;

import adt.Pair;
import model.Board;
import constants.*;
import model.Dice;

public class GameView {
    Scanner scanner;

    public GameView() {
        scanner = new Scanner(System.in);
    }

    public void printBoard(Board board, String currentPlayer, int currentMatch, int matchLength, int stake, int player1Score, int player2Score) {
        System.out.println("Current Player: " + currentPlayer + "\n");
        System.out.println("Game " + currentMatch + " of " + matchLength);
        System.out.println("Game Stake: " + stake);
        System.out.println("Player 1 Score: " + player1Score + " | Player 2 Score: " + player2Score);
        System.out.println(board);
    }

    public String promptForPlayerName(int playerNumber) {
        System.out.println("Enter Player " + playerNumber + " name: ");
        return scanner.nextLine();
    }

    public int promptForMatchLength() {
        System.out.println("Enter match length: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        }
        catch (Exception e){
            System.out.println("Invalid input. Please enter a number.");
            return promptForMatchLength();
        }
    }

    public void printMenu() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("|  'Q'                  - Quit                              |");
        System.out.println("|  'pip'                - Print pips                        |");
        System.out.println("|  'roll'               - Roll Dice                         |");
        System.out.println("|  'double'             - Offer double                      |");
        System.out.println("|  'new match'          - Start new match                   |");
        System.out.println("|  'dice <int> <int>'   - Set your own dice values          |");
        System.out.println("|  'test <filename>'    - Executes commands from <filename> |");
        System.out.println("-------------------------------------------------------------");
    }

    public String getUserCommand() {
        System.out.println("Enter command: ");
        return scanner.nextLine().trim();
    }

    public String getDoubleAnswer(String currentPlayer, String player1, String player2) {
        String otherPlayer = currentPlayer.equals(player1) ? player2 : player1;
        System.out.println(otherPlayer + ", do you 'accept' or 'refuse' the double? ");
        return scanner.nextLine();
    }

    public Pair<String, String> askForPlayerNames() {
        String player1Name = promptForPlayerName(1);
        String player2Name = promptForPlayerName(2);
        System.out.println("Welcome " + player1Name + " and " + player2Name + "!");
        return new Pair<>(player1Name, player2Name);
    }

    public void displayPipCounts(Board board, String playerColor) {
        Map<Integer, Integer> pipCounts = board.calculatePipCounts(playerColor.substring(playerColor.length() - 2, playerColor.length() - 1));
        int totalPips = pipCounts.getOrDefault(0, 0); // Retrieve the total pips from the map

        StringBuilder details = new StringBuilder();
        details.append(playerColor).append("'s pip score : ").append(totalPips);

        for (int point = 1; point <= GameConstants.POINTS; point++) {
            if (pipCounts.containsKey(point)) {
                details.append("\nCone ").append(point).append(" -> ").append(pipCounts.get(point));
            }
        }
        System.out.println(details);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayWinner(int player1Score, int player2Score, String player1, String player2) {
        String returnString;
        if (player1Score != player2Score){
            String winner =  (player1Score > player2Score) ? player1 : player2;
            returnString = winner+" wins!";
        }
        else{
            returnString = "It's a tie!";
        }

        System.out.println("-------------------------");
        System.out.println(returnString);
        System.out.println(player1 +" Points: "+player1Score);
        System.out.println(player2+ " Points: " + player2Score);
        System.out.println("-------------------------");
    }

    public Integer getPlayerMove(int maxIndex) {
        while (true) {
            System.out.print("Choose move: ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 0 && index <= maxIndex) {
                    return index;
                }
                System.out.println("Invalid move");
            } catch (Exception e) {
                System.out.println("Invalid move");
            }
        }
    }

    public void printPossibleMoves(ArrayList<Pair<Pair<String, String>, Pair<String, String>>> moves, String currentPlayer, Dice dice) {
        if (moves.isEmpty()) {
            System.out.println("No more moves to play!");
            return;
        }
        System.out.printf("%s to play %s. %s:\n%s", currentPlayer, dice.getDice(),
                (moves.size() == 1 ? "Forced move" : "Select from"),
                (moves.size() == 1 ? moves.getFirst().first + " " + ((moves.getFirst().second.first.isEmpty()) ? "" : moves.getFirst().second) + "\n" : ""));
        if (moves.size() == 1) return;
        for (int i = 0; i < moves.size(); ++i) {
            System.out.println(i + ") Play " + moves.get(i).first + " " + ((moves.get(i).second.first.isEmpty()) ? "" : moves.get(i).second));
        }
    }
}