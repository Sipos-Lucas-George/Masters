package model;

import static constants.GameConstants.CHECKERS;

public class BearOff {
    private int white;
    private int red;

    public int getWhite() {
        return white;
    }

    public int getRed() {
        return red;
    }

    public BearOff() {
        white = 0;
        red = 0;
    }

    public void bearOffWhite() {
        if (white == CHECKERS) {
            return;
        }
        ++white;
    }

    public void bearOffRed() {
        if (red == CHECKERS) {
            return;
        }
        ++red;
    }

    public boolean whiteWon() {
        return white == CHECKERS;
    }

    public boolean redWon() {
        return red == CHECKERS;
    }

    public void reset() {
        white = 0;
        red = 0;
    }
}
