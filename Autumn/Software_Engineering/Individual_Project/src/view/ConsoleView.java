package view;

import model.DrawPile;
import model.Foundations;
import model.GameTracker;
import model.Lanes;

public class ConsoleView {
    public void displayGame(GameTracker gameTracker, DrawPile drawPile, Lanes lanes, Foundations foundations) {
        System.out.println(gameTracker);
        System.out.println(drawPile);
        System.out.println(lanes);
        System.out.println(foundations);
    }

    public void displayRequestCommand() {
        System.out.print("Insert command > ");
    }

    public void displayInvalidCommandError() {
        System.out.println("Invalid command! Please insert another command.");
    }

    public void displayInvalidMoveError() {
        System.out.println("Invalid move! Please insert another command.");
    }

    public void displayGameWon() {
        System.out.println("You WON!!! 👏");
    }

    public void displayGameLost() {
        System.out.println("You LOST... You'll get it next time!");
    }

    public void displayRules() {
        System.out.println("D           - uncover a new card from draw pile");
        System.out.println("<A><B>      - move card(s) from A to B");
        System.out.println("<A><B><N>   - move N card(s) from A to B");
        System.out.println("R           - display rules");
        System.out.println("Q           - quit");
    }
}
