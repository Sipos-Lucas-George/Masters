package controller;

import adt.Pair;
import model.*;
import view.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static constants.GameConstants.CHECKERS;
import static constants.GameConstants.FOLDER_PATH;

import constants.GameConstants;


public class GameController {
    private final GameView view;
    public final Board board;
    public final BearOff bearOff;
    public final Dice dice;
    public final DoublingCube doublingCube;
    public String currentPlayer;
    public String player1;
    public String player2;
    public static int matchLength;
    public static int currentMatch = 1;
    public int player1Score = 0;
    public int player2Score = 0;
    private boolean gameIsOver;

    public GameController(GameView view) {
        this.view = view;
        this.board = new Board();
        this.dice = new Dice();
        this.bearOff = new BearOff();
        this.doublingCube = new DoublingCube();
        this.gameIsOver = false;

        Pair<String, String> names = view.askForPlayerNames();
        player1 = names.first;
        player2 = names.second;

        matchLength = view.promptForMatchLength();
    }

    public void playMatch() {
        while (currentMatch <= matchLength) {
            startGame();
        }

        view.displayWinner(player1Score, player2Score, player1, player2);
        System.exit(0);
    }

    public void startGame() {

        view.displayMessage("Match " + currentMatch + " of " + matchLength);

        // assigning colors to players
        currentPlayer = determineStartingPlayer(player1, player2).equals(player1) ? "W" : "R";
        view.displayMessage("The starting player is: " + getCurrentPlayerPrintName());

        view.printMenu();

        while (true) {
            view.printBoard(board, getCurrentPlayerPrintName(), currentMatch, matchLength, doublingCube.getValue(), player1Score, player2Score);
            view.displayPipCounts(board, getCurrentPlayerPrintName());
            String command = view.getUserCommand();

            if (command.equalsIgnoreCase("double")) {
                if (!doubleFunctionality(((currentPlayer.equals("W")) ? player1 : player2))) {
                    break;
                }
                command = view.getUserCommand();
            }

            command = command.trim();

            if (command.equalsIgnoreCase("Q")) {
                quitGame();
            } else if ("roll".startsWith(command.toLowerCase())) {
                dice.roll();
                showAndMakeMoves();
                if (gameIsOver) {
                    break;
                }
            } else if (command.toLowerCase().startsWith("dice")) {
                try {
                    String[] commandParts = command.split("\\s+");
                    if (commandParts.length == 3) {
                        int first = Integer.parseInt(commandParts[1]), second = Integer.parseInt(commandParts[2]);
                        dice.setDice(first, second);
                        view.displayMessage("Dice set to: " + first + " - " + second);
                        showAndMakeMoves();
                    } else {
                        view.displayMessage("Invalid command format. Usage: 'dice X Y' where X and Y are digits.");
                    }
                } catch (Exception e) {
                    view.displayMessage("Invalid input. Please ensure you enter two digits after 'dice'.");
                }
            } else if (command.equalsIgnoreCase("pip")) {
                reportPipCounts();
                continue;
            } else if (command.equalsIgnoreCase("hint")) {
                view.printMenu();
                continue;
            } else if (command.equalsIgnoreCase("new match")) {
                startNewMatch();
            } else if (command.startsWith("test")) {
                File file = verifyTestCommand(command);
                if (file == null) {
                    continue;
                }
                if (!executeFileCommands(file)) {
                    view.displayMessage("Something with the file went wrong. Please try again.");
                }
                continue;
            } else {
                view.displayMessage("Invalid command. Please try again.");
                continue;
            }
            // take additional commands

            swapCurrentPlayer();
        }
    }

    public void startNewMatch() {
        if (currentMatch >= matchLength) {
            view.displayMessage("Match length reached. No new matches can be started.");
            return;
        }
        // Reset the board, dice, and bear off states for a new match
        board.reset();
        dice.reset();
        bearOff.reset();

        currentMatch++;
        view.displayMessage("Starting new match " + currentMatch + " of " + matchLength);

        // Determine starting player again
        currentPlayer = determineStartingPlayer(player1, player2).equals(player1) ? "W" : "R";
        view.displayMessage("The starting player for the new match is: " + getCurrentPlayerPrintName());
    }


    public void showAndMakeMoves() {
        int turns = dice.getDice().first.equals(dice.getDice().second) ? 2 : 1;
        for (int i = 1; i <= turns; ++i) {
            ArrayList<Pair<Pair<String, String>, Pair<String, String>>> moves = (currentPlayer.equals("W"))
                    ? board.getMovesP1(dice.getDice(), CHECKERS - bearOff.getWhite())
                    : board.getMovesP2(dice.getDice(), CHECKERS - bearOff.getRed());
            view.printPossibleMoves(moves, getCurrentPlayerPrintName(), dice);
            if (moves.isEmpty()) continue;
            if (moves.size() == 1) {
                board.makeMove(bearOff, moves.getFirst().first.first, moves.getFirst().first.second, currentPlayer);
                board.makeMove(bearOff, moves.getFirst().second.first, moves.getFirst().second.second, currentPlayer);
            } else {
                int index = view.getPlayerMove(moves.size() - 1);
                board.makeMove(bearOff, moves.get(index).first.first, moves.get(index).first.second, currentPlayer);
                board.makeMove(bearOff, moves.get(index).second.first, moves.get(index).second.second, currentPlayer);
            }
            if (turns == 2) {
                view.printBoard(board, getCurrentPlayerPrintName(), currentMatch, matchLength, doublingCube.getValue(), player1Score, player2Score);
            }
            if ((currentPlayer.equals("W")) ? bearOff.whiteWon() : bearOff.redWon()) {
                view.printBoard(board, getCurrentPlayerPrintName(), currentMatch, matchLength, doublingCube.getValue(), player1Score, player2Score);
                gameOver(getCurrentPlayerPrintName());
            }
        }
    }

    private void reportPipCounts() {
        Map<Integer, Integer> pipCountsWhite = board.calculatePipCounts("W");
        Map<Integer, Integer> pipCountsRed = board.calculatePipCounts("R");

        view.displayMessage(player1 + " (W)'s pip score: " + pipCountsWhite.get(0));
        view.displayMessage(player2 + " (R)'s pip score: " + pipCountsRed.get(0));
    }

    private void swapCurrentPlayer() {
        currentPlayer = (currentPlayer.equals("W")) ? "R" : "W";
        view.displayMessage("It's now " + getCurrentPlayerPrintName() + "'s turn.");
    }

    public String determineStartingPlayer(String player1Name, String player2Name) {
        Pair<Integer, Integer> dicePair = dice.roll();
        view.displayMessage(player1Name + " rolled: " + dicePair.first);
        view.displayMessage(player2Name + " rolled: " + dicePair.second);

        if (dicePair.first > dicePair.second) {
            return player1Name;
        } else if (dicePair.second > dicePair.first) {
            return player2Name;
        } else {
            view.displayMessage("It's a tie! Rolling again...");
            return determineStartingPlayer(player1Name, player2Name); // Roll again if it's a tie
        }
    }

    public String getCurrentPlayerPrintName() {
        return ((currentPlayer.equals("W")) ? player1 : player2) + " (" + currentPlayer + ")";
    }

    public void quitGame() {
        if (currentPlayer == null) {
            view.displayMessage("No active game to quit. Exiting...");
        } else {
            String otherPlayer = currentPlayer.equals("W") ? player2 : player1;
            view.displayMessage("Sad to see you go... " + otherPlayer + " wins by default!");
        }
        System.exit(0); // Exit the application
    }


    public void gameOver(String winner) {
        String winType = determineWinType();
        int pointsGained = doublingCube.getValue() * (winType.equals("Single Win") ? 1 : winType.equals("Gammon") ? 2 : 3);

        view.displayMessage("Game Over, " + winner + " wins with a " + winType + " and gains " + pointsGained + " points!");
        if (winner.equals(player1)) {
            player1Score += pointsGained;
        } else {
            player2Score += pointsGained;
        }
        currentMatch++;
        resetGame();
        gameIsOver = true;
    }


    public boolean doubleFunctionality(String currentPlayer) {
        String doubleAnswer = "";

        if (!doublingCube.canDouble(currentPlayer)) {
            view.displayMessage("You cannot double at this time.");
        } else {
            doubleAnswer = view.getDoubleAnswer(currentPlayer, player1, player2);
            if (doubleAnswer.equalsIgnoreCase("accept") && doublingCube.canDouble(currentPlayer)) {
                doublingCube.doubleCube(currentPlayer, player1, player2);
                return true;
            } else if (doubleAnswer.equalsIgnoreCase("refuse") && doublingCube.canDouble(currentPlayer)) {
                gameOver(currentPlayer);
                return false;
            } else {
                view.displayMessage("Invalid input");
                doubleFunctionality(currentPlayer);
            }
        }
        return false;

    }

    private void resetGame() {
        board.resetBoard();
        bearOff.reset();
        doublingCube.reset();
    }

    private String determineWinType() {
        boolean isWhiteWinner = bearOff.whiteWon();

        // Check if the loser has borne off any checkers
        boolean hasLoserBorneOff = isWhiteWinner ? bearOff.getRed() > 0 : bearOff.getWhite() > 0;

        // Check if the loser has checkers on the bar or in the winner's home board
        boolean hasLoserCheckersOnBar = isWhiteWinner
                ? !board.getPoints()[GameConstants.RED_BAR].isEmpty()
                : !board.getPoints()[GameConstants.WHITE_BAR].isEmpty();

        boolean hasLoserCheckersInHome = isWhiteWinner
                ? board.hasCheckersInHomeBoard("W", "R")
                : board.hasCheckersInHomeBoard("R", "W");

        // Determine win type
        if (!hasLoserBorneOff && (hasLoserCheckersOnBar || hasLoserCheckersInHome)) {
            return "Backgammon"; // Check Backgammon first
        } else if (!hasLoserBorneOff) {
            return "Gammon"; // No checkers borne off and no checkers on bar/home
        } else {
            return "Single Win"; // At least one checker borne off
        }
    }



    private File verifyTestCommand(String testCommand) {
        String[] commandParts = testCommand.split("\\s+");
        if (commandParts.length != 2) {
            view.displayMessage("Invalid command format. Please try again.");
            return null;
        }
        File file = fileExists(commandParts[1]);
        if (file == null) {
            view.displayMessage("Invalid file name. Please try again.");
            return null;
        }
        return file;
    }

    private File fileExists(String fileName) {
        File file = new File(FOLDER_PATH, fileName);
        return (file.exists() && file.isFile()) ? file : null;
    }

    private boolean executeFileCommands(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split(",");
                if (args.length == 0) continue;
                String command = args[0];
                view.printBoard(board, getCurrentPlayerPrintName(), currentMatch, matchLength, doublingCube.getValue(), player1Score, player2Score);
                view.displayPipCounts(board, getCurrentPlayerPrintName());

                view.displayMessage("Command extracted from " + file.getName() + ": " + command);

                if (command.equalsIgnoreCase("double")) {
                    if (!doubleFunctionality(((currentPlayer.equals("W")) ? player1 : player2))) {
                        break;
                    }
                    command = view.getUserCommand();
                }

                command = command.trim();

                if (command.equalsIgnoreCase("Q")) {
                    quitGame();
                } else if ("roll".startsWith(command.toLowerCase())) {
                    dice.roll();
                    showAndMakeMoves();
                    if (gameIsOver) {
                        break;
                    }
                } else if (command.toLowerCase().startsWith("dice")) {
                    try {
                        if (args.length == 3) {
                            int first = Integer.parseInt(args[1]), second = Integer.parseInt(args[2]);
                            dice.setDice(first, second);
                            view.displayMessage("Dice set to: " + first + " - " + second);
                            showAndMakeMoves();
                        } else {
                            view.displayMessage("Invalid command format. Usage: 'dice X Y' where X and Y are digits.");
                        }
                    } catch (Exception e) {
                        view.displayMessage("Invalid input. Please ensure you enter two digits after 'dice'.");
                    }
                } else if (command.equalsIgnoreCase("pip")) {
                    reportPipCounts();
                    continue;
                } else if (command.equalsIgnoreCase("hint")) {
                    view.printMenu();
                    continue;
                } else if (command.equalsIgnoreCase("new match")) {
                    startNewMatch();
                } else if (command.startsWith("test")) {
                    File nextFile = verifyTestCommand(command);
                    if (nextFile == null) {
                        continue;
                    }
                    if (!executeFileCommands(nextFile)) {
                        view.displayMessage("Something with the file went wrong. Please try again.");
                    }
                    continue;
                } else {
                    view.displayMessage("Invalid command. Please try again.");
                    continue;
                }
                // take additional commands

                swapCurrentPlayer();
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}