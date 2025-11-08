package model;
import adt.Pair;
import java.util.*;

public class Dice {
    private Pair<Integer, Integer> dice;

    public Dice() {
    }

    public Pair<Integer, Integer> roll() {
        Random random = new Random();
        dice = new Pair<>(random.nextInt(6)+1, random.nextInt(6)+1);
        return dice;
    }

    public void setDice(int first, int second) {
        this.dice = new Pair<>(first, second);
    }

    public void reset() {
        this.dice = null;
    }


    public Pair<Integer, Integer> getDice() {
        return dice;
    }
}
