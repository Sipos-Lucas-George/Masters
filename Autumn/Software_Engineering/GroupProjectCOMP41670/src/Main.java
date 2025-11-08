import controller.GameController;
import view.*;

public class Main {
    public static void main(String[] args) {
        GameView view = new GameView();
        GameController gameController = new GameController(view);
        gameController.playMatch();
    }
}