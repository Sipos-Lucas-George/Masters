
public class Player {
    private int score;
    private boolean hold = false;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public boolean isHeld() {
        return hold;
    }

    public String getName() {
        return name;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public void addCard(int card) {
        score += card;
        if (score == Game.WINNING_SCORE) {
            hold = true;
        } else if (score > 21) {
            hold = true;
        }
    }

    public String toString() {
        return "Player: " + getName() + " current score: " + getScore();
    }
}
