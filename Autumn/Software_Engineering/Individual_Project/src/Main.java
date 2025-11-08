import controller.GameController;
import model.Deck;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        GameController gameController = new GameController(deck);
        gameController.run();
    }
}
