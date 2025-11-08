package model;

public class GameTracker {
    private int moves = 0;
    private int score = 0;

    public GameTracker() {}

    public void increaseMoves() {
        ++moves;
    }

    public void moveCardBetweenLanes() {
        score += 5;
        ++moves;
    }

    public void moveCardFromDrawPile2Foundation() {
        score += 10;
        ++moves;
    }

    public void moveCardFromLane2Foundation() {
        score += 20;
        ++moves;
    }

    @Override
    public String toString() {
        return "Score: " + score + "\n" + "Moves: " + moves + "\n";
    }
}
