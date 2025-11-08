package model;

import java.util.ArrayList;
import java.util.Stack;
import static constants.GameConstants.POINTS;

public class Board {
    private ArrayList<Checker>[] points; // Array of stacks representing the 24 points

    public Board() {
        points = new ArrayList[POINTS + 1]; // Creating an array of Stacks
        for (int i = 1; i <= POINTS; ++i) {
            points[i] = new ArrayList<>(); // Initialize each point as a Stack
        }
        // Initialize board with checkers at starting positions
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 1; i <= 5; ++i) {
            points[6].add(new Checker("W"));
            points[12].add(new Checker("R"));
            points[13].add(new Checker("W"));
            points[19].add(new Checker("R"));
        }
        for (int i = 1; i <= 3; ++i) {
            points[8].add(new Checker("W"));
            points[17].add(new Checker("R"));
        }
        for (int i = 1; i <= 2; ++i) {
            points[1].add(new Checker("R"));
            points[24].add(new Checker("W"));
        }
    }

    @Override
    public String toString() {
        final int TEXT_FORMAT_OFFSET = 5;
        final String BLANK_SPACES = "     ";
        final int BLANK_LINES = 3;
        final String LINE_SPACES = "--";
        final int LINE_SPACES_REPEAT = 35;
        final String MIDDLE_BAR = " |   ";
        final String START_LINE = "|  ";
        final String END_LINE = " |";
        StringBuilder result = new StringBuilder();

        for (int i = 13; i <= 24; ++i) {
            if (i == 13) {
                result.append(" ".repeat(START_LINE.length()));
            }
            StringBuilder stringBuilderNumbers = new StringBuilder();
            stringBuilderNumbers.append(i).append(BLANK_SPACES);
            result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
            if (i == 18) {
                result.append(MIDDLE_BAR);
            } else if (i == 24) {
                result.append(" ".repeat(END_LINE.length()));
            }
        }
        result.append("\n");

        result.append(LINE_SPACES.repeat(LINE_SPACES_REPEAT));
        result.append("\n");

        int maxSizeUp = 0, maxSizeDown = 0;
        for (int i = 1; i <= 12; ++i) {
            maxSizeDown = Math.max(maxSizeDown, points[i].size());
            maxSizeUp = Math.max(maxSizeUp, points[POINTS - i + 1].size());
        }

        for (int j = 0; j < maxSizeUp; ++j) {
            for (int i = 13; i <= 24; ++i) {
                if (i == 13) {
                    result.append(START_LINE);
                }
                StringBuilder stringBuilderNumbers = new StringBuilder();
                if (points[i].size() > j) {
                    stringBuilderNumbers.append(points[i].get(j)).append(BLANK_SPACES);
                } else {
                    stringBuilderNumbers.append(BLANK_SPACES);
                }
                result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
                if (i == 18) {
                    result.append(MIDDLE_BAR);
                } else if (i == 24) {
                    result.append(END_LINE);
                }
            }
            result.append("\n");
        }

        for (int j = 0; j < BLANK_LINES; ++j) {
            for (int i = 13; i <= 24; ++i) {
                if (i == 13) {
                    result.append(START_LINE);
                }
                StringBuilder stringBuilderNumbers = new StringBuilder();
                stringBuilderNumbers.append(BLANK_SPACES);
                result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
                if (i == 18) {
                    result.append(MIDDLE_BAR);
                } else if (i == 24) {
                    result.append(END_LINE);
                }
            }
            result.append("\n");
        }

        for (int j = maxSizeDown; j >= 1; --j) {
            for (int i = 12; i >= 1; --i) {
                if (i == 12) {
                    result.append(START_LINE);
                }
                StringBuilder stringBuilderNumbers = new StringBuilder();
                if (points[i].size() >= j) {
                    stringBuilderNumbers.append(points[i].get(j - 1)).append(BLANK_SPACES);
                } else {
                    stringBuilderNumbers.append(BLANK_SPACES);
                }
                result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
                if (i == 7) {
                    result.append(MIDDLE_BAR);
                } else if (i == 1) {
                    result.append(END_LINE);
                }
            }
            result.append("\n");
        }

        result.append(LINE_SPACES.repeat(LINE_SPACES_REPEAT));
        result.append("\n");

        for (int i = 12; i >= 1; --i) {
            if (i == 12) {
                result.append(" ".repeat(START_LINE.length()));
            }
            StringBuilder stringBuilderNumbers = new StringBuilder();
            stringBuilderNumbers.append(i).append(BLANK_SPACES);
            result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
            if (i == 7) {
                result.append(MIDDLE_BAR);
            } else if (i == 1) {
                result.append(" ".repeat(END_LINE.length()));
            }
        }
        result.append("\n");

        return result.toString();
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
    }
}

