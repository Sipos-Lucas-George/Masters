package model;

import adt.Pair;

import java.util.*;

import constants.*;

import static constants.GameConstants.*;

public class Board {
    private ArrayList<Checker>[] points; // Array of ArrayLists representing the 24 points

    public Board() {
        points = new ArrayList[POINTS + 2]; // Creating an array of ArrayLists
        // 0 = Red BAR, 25 = White BAR, other = point
        for (int i = 0; i <= POINTS + 1; ++i) {
            points[i] = new ArrayList<>(); // Initialize each point as an ArrayList
        }
        // Initialize board with checkers at starting positions
        initializeBoard();
    }

    public void resetBoard() {
        for (int i = 1; i <= POINTS; i++) {
            points[i].clear();
        }
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

    public Map<Integer, Integer> calculatePipCounts(String playerColor) {
        Map<Integer, Integer> pipCounts = new HashMap<>();
        int totalPips = 0;

        for (int point = 1; point <= GameConstants.POINTS; point++) {
            ArrayList<Checker> checkersAtPoint = points[point];
            int numCheckers = 0;

            for (Checker checker : checkersAtPoint) {
                if (checker.color().equalsIgnoreCase(playerColor)) {
                    numCheckers++;
                }
            }

            if (numCheckers > 0) {
                int pointPipValue = numCheckers * (playerColor.equals("R") ? (25 - point) : point);
                totalPips += pointPipValue;
                pipCounts.put(point, pointPipValue);
            }
        }

        pipCounts.put(0, totalPips); // Use 0 as a key for total pips
        return pipCounts;
    }

    public void makeMove(BearOff bearOff, String from, String to, String player) {
        if (from.isEmpty()) return;
        if (from.equals("BAR")) {
            Checker checker = (player.equals("W")) ? points[WHITE_BAR].removeFirst() : points[RED_BAR].removeFirst();
            int toInt = Integer.parseInt(to);
            if (!points[toInt].isEmpty() && !points[toInt].getFirst().color().equals(player)) {
                points[(player.equals("W")) ? RED_BAR : WHITE_BAR].add(points[toInt].removeFirst());
            }
            points[toInt].add(checker);
        } else if (to.equals("OFF")) {
            if ((player.equals("W"))) {
                bearOff.bearOffWhite();
            } else {
                bearOff.bearOffRed();
            }
            points[Integer.parseInt(from)].removeLast();
        } else {
            int toInt = Integer.parseInt(to);
            Checker checker = points[Integer.parseInt(from)].removeFirst();
            if (!points[toInt].isEmpty() && !points[toInt].getFirst().color().equals(player)) {
                points[(player.equals("W")) ? RED_BAR : WHITE_BAR].add(points[toInt].removeFirst());
            }
            points[toInt].add(checker);
        }
    }

    public ArrayList<Pair<Pair<String, String>, Pair<String, String>>> getMovesP1(Pair<Integer, Integer> dice, int checkersLeft) {
        ArrayList<Pair<Pair<String, String>, Pair<String, String>>> moves = new ArrayList<>();
        if (!points[WHITE_BAR].isEmpty()) { // check for hit checkers
            for (int number : new int[]{dice.first, dice.second}) {
                if (checkPoint(WHITE_BAR - number, "W")) {
                    int otherNumber = (dice.first == number) ? dice.second : dice.first;
                    boolean madePair = false; // possible to not have a second move after entering
                    if (points[WHITE_BAR].size() == 1) {
                        if (checkPoint(WHITE_BAR - number - otherNumber, "W")) { // move the entered checker
                            moves.add(new Pair<>(
                                    new Pair<>("BAR", Integer.toString(WHITE_BAR - number)),
                                    new Pair<>(Integer.toString(WHITE_BAR - number), Integer.toString(WHITE_BAR - number - otherNumber))));
                            madePair = true;
                        }
                        for (int point = POINTS; point > RED_BAR; --point) {
                            if (point - otherNumber > RED_BAR && !points[point].isEmpty() && points[point].getFirst().color().equals("W")
                                    && checkPoint(point - number, "W")) {
                                moves.add(new Pair<>(
                                        new Pair<>("BAR", Integer.toString(WHITE_BAR - number)),
                                        new Pair<>(Integer.toString(point), Integer.toString(point - otherNumber))));
                                madePair = true;
                            }
                        }
                    } else {
                        if (checkPoint(WHITE_BAR - otherNumber, "W")) {
                            moves.add(new Pair<>(
                                    new Pair<>("BAR", Integer.toString(WHITE_BAR - number)),
                                    new Pair<>("BAR", Integer.toString(WHITE_BAR - otherNumber))));
                            madePair = true;
                        }
                    }
                    if (!madePair) {
                        moves.add(new Pair<>(
                                new Pair<>("BAR", Integer.toString(WHITE_BAR - number)),
                                new Pair<>("", "")));
                    }
                }
            }
            return sort(filterDuplicates(sort(moves, -1)), -1);
        }
        for (int number : new int[]{dice.first, dice.second}) {
            for (int point1 = POINTS; point1 > RED_BAR; --point1) {
                int notHome = getNotHome(7, POINTS, "W"); // how many checkers not in home
                int offset = (notHome == 0) ? -6 : RED_BAR; // offset to see if player can bear off or not
                if (!(point1 - number > offset && !points[point1].isEmpty()
                        && points[point1].getFirst().color().equals("W")
                        && checkPoint(point1 - number, "W"))) {
                    continue;
                }
                int otherNumber = (dice.first == number) ? dice.second : dice.first;
                // check if first move got last checker home
                if (notHome == 1 && point1 > 6 && point1 - number <= 6) offset = -6;
                if (point1 - number - otherNumber > offset && checkPoint(point1 - number - otherNumber, "W")
                        && point1 - number > RED_BAR) {
                    moves.add(new Pair<>(
                            new Pair<>(Integer.toString(point1), isBearingOff(point1 - number)),
                            new Pair<>(Integer.toString(point1 - number), isBearingOff(point1 - number - otherNumber))));
                }
                if (checkersLeft == 1) {
                    moves.add(new Pair<>(
                            new Pair<>(Integer.toString(point1), isBearingOff(point1 - number)),
                            new Pair<>("", "")));
                }
                for (int point2 = point1; point2 > RED_BAR; --point2) {
                    if (point2 - otherNumber > offset && !points[point2].isEmpty()
                            && points[point2].getFirst().color().equals("W")
                            && checkPoint(point2 - otherNumber, "W")) {
                        if (point1 == point2 && points[point2].size() < 2) continue;
                        moves.add(new Pair<>(
                                new Pair<>(Integer.toString(point1), isBearingOff(point1 - number)),
                                new Pair<>(Integer.toString(point2), isBearingOff(point2 - otherNumber))));
                    }
                }
            }
        }
        return sort(filterDuplicates(sort(moves, -1)), -1);
    }

    public ArrayList<Pair<Pair<String, String>, Pair<String, String>>> getMovesP2(Pair<Integer, Integer> dice, int checkersLeft) {
        ArrayList<Pair<Pair<String, String>, Pair<String, String>>> moves = new ArrayList<>();
        if (!points[RED_BAR].isEmpty()) { // check for hit checkers
            for (int number : new int[]{dice.first, dice.second}) {
                if (checkPoint(number, "R")) {
                    int otherNumber = (dice.first == number) ? dice.second : dice.first;
                    boolean madePair = false; // possible to not have a second move after entering
                    if (points[RED_BAR].size() == 1) {
                        if (checkPoint(number + otherNumber, "R")) { // move the entered checker
                            moves.add(new Pair<>(
                                    new Pair<>("BAR", Integer.toString(number)),
                                    new Pair<>(Integer.toString(number), Integer.toString(number + otherNumber))));
                            madePair = true;
                        }
                        for (int point = 1; point <= POINTS; ++point) {
                            if (point + otherNumber <= POINTS && !points[point].isEmpty() && points[point].getFirst().color().equals("R")
                                    && checkPoint(point + number, "R")) {
                                moves.add(new Pair<>(
                                        new Pair<>("BAR", Integer.toString(number)),
                                        new Pair<>(Integer.toString(point), Integer.toString(point + otherNumber))));
                                madePair = true;
                            }
                        }
                    } else {
                        if (checkPoint(otherNumber, "R")) {
                            moves.add(new Pair<>(
                                    new Pair<>("BAR", Integer.toString(number)),
                                    new Pair<>("BAR", Integer.toString(otherNumber))));
                            madePair = true;
                        }
                    }
                    if (!madePair) {
                        moves.add(new Pair<>(
                                new Pair<>("BAR", Integer.toString(number)),
                                new Pair<>("", "")));
                    }
                }
            }
            return sort(filterDuplicates(sort(moves, 1)), 1);
        }
        for (int number : new int[]{dice.first, dice.second}) {
            for (int point1 = 1; point1 <= POINTS; ++point1) {
                int notHome = getNotHome(1, 18, "R"); // how many checkers not in home
                int offset = (notHome == 0) ? 31 : WHITE_BAR; // offset to see if player can bear off or not
                if (!(point1 + number < offset && !points[point1].isEmpty()
                        && points[point1].getFirst().color().equals("R")
                        && checkPoint(point1 + number, "R"))) {
                    continue;
                }
                int otherNumber = (dice.first == number) ? dice.second : dice.first;
                // check if first move got last checker home
                if (notHome == 1 && point1 < 19 && point1 + number >= 19) offset = 31;
                if (point1 + number + otherNumber < offset && checkPoint(point1 + number + otherNumber, "R")
                        && point1 + number < WHITE_BAR) {
                    moves.add(new Pair<>(
                            new Pair<>(Integer.toString(point1), isBearingOff(point1 + number)),
                            new Pair<>(Integer.toString(point1 + number), isBearingOff(point1 + number + otherNumber))));
                }
                if (checkersLeft == 1) {
                    moves.add(new Pair<>(
                            new Pair<>(Integer.toString(point1), isBearingOff(point1 + number)),
                            new Pair<>("", "")));
                }
                for (int point2 = point1; point2 <= POINTS; ++point2) {
                    if (point2 + otherNumber < offset && !points[point2].isEmpty()
                            && points[point2].getFirst().color().equals("R")
                            && checkPoint(point2 + otherNumber, "R")) {
                        if (point1 == point2 && points[point2].size() < 2) continue;
                        moves.add(new Pair<>(
                                new Pair<>(Integer.toString(point1), isBearingOff(point1 + number)),
                                new Pair<>(Integer.toString(point2), isBearingOff(point2 + otherNumber))));
                    }
                }
            }
        }
        return sort(filterDuplicates(sort(moves, 1)), 1);
    }

    private boolean checkPoint(int point, String player) {
        return point < 1 || point > POINTS || points[point].isEmpty()
                || points[point].getFirst().color().equals(player) || points[point].size() == 1;
    }

    public ArrayList<Checker>[] getPoints() {
        return points;
    }

    private int getNotHome(int start, int end, String player) {
        int checkers = 0;
        for (int i = start; i <= end; ++i) {
            if (!points[i].isEmpty() && points[i].getFirst().color().equals(player)) {
                checkers += points[i].size();
            }
        }
        return checkers;
    }

    private String isBearingOff(int number) {
        return (number > 24 || number < 1) ? "OFF" : Integer.toString(number);
    }

    private ArrayList<Pair<Pair<String, String>, Pair<String, String>>> filterDuplicates(ArrayList<Pair<Pair<String, String>, Pair<String, String>>> moves) {
        Set<Pair<Pair<String, String>, Pair<String, String>>> uniquePairs = new HashSet<>();
        for (Pair<Pair<String, String>, Pair<String, String>> pair : moves) {
            if (!(uniquePairs.contains(new Pair<>(pair.first, pair.second)) || uniquePairs.contains(new Pair<>(pair.second, pair.first)))) {
                uniquePairs.add(pair);
            }
        }
        return new ArrayList<>(uniquePairs);
    }

    private ArrayList<Pair<Pair<String, String>, Pair<String, String>>> sort(ArrayList<Pair<Pair<String, String>, Pair<String, String>>> moves, int offset) {
        moves.sort((p1, p2) -> {
            int comparison;

            comparison = compareString(p1.first.first, p2.first.first, offset);
            if (comparison != 0) return comparison;

            comparison = compareString(p1.first.second, p2.first.second, offset);
            if (comparison != 0) return comparison;

            comparison = compareString(p1.second.first, p2.second.first, offset);
            if (comparison != 0) return comparison;

            return compareString(p1.second.second, p2.second.second, offset);
        });
        return moves;
    }

    public void reset() {
        for (int i = 0; i <= POINTS + 1; ++i) {
            points[i].clear();
        }
        initializeBoard();
    }

    public boolean hasCheckersInHomeBoard(String winnerColor, String loserColor) {
        int start = winnerColor.equals("W") ? 19 : 1; // Red's home board is points 1-6, White's is points 19-24
        int end = winnerColor.equals("W") ? 24 : 6;

        for (int i = start; i <= end; ++i) {
            if (!points[i].isEmpty() && points[i].get(0).color().equals(loserColor)) {
                return true;
            }
        }
        return false;
    }




    private int compareString(String str1, String str2, int offset) {
        if (str1.length() < str2.length()) return -1 * offset;
        else if (str1.length() > str2.length()) return offset;
        return str1.compareTo(str2) * offset;
    }

    @Override
    public String toString() {
        final int TEXT_FORMAT_OFFSET = 5;
        final String BLANK_SPACES = "     ";
        final String LINE_SPACES = "-";
        final int LINE_SPACES_REPEAT = 35;
        final String START_LINE = "|   ";
        final String END_LINE = "|";
        final String BAR = " BAR ";
        StringBuilder result = new StringBuilder();

        for (int i = 13; i <= 24; ++i) {
            if (i == 13) {
                result.append(" ".repeat(START_LINE.length()));
            }
            StringBuilder stringBuilderNumbers = new StringBuilder();
            stringBuilderNumbers.append(i).append(BLANK_SPACES);
            result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
            if (i == 18) {
                result.append(END_LINE).append(BAR).append(START_LINE);
            } else if (i == 24) {
                result.append(" ".repeat(END_LINE.length()));
            }
        }
        result.append("\n");

        result.append(LINE_SPACES.repeat(LINE_SPACES_REPEAT)).append(" ".repeat(BAR.length())).append(LINE_SPACES.repeat(LINE_SPACES_REPEAT));
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
                    result.append(END_LINE).append(" ".repeat(BAR.length())).append(START_LINE);
                } else if (i == 24) {
                    result.append(END_LINE);
                }
            }
            result.append("\n");
        }

        StringBuilder checkers = new StringBuilder();
        checkers.append(" ").append("W".repeat(points[WHITE_BAR].size())).append("R".repeat(points[RED_BAR].size())).append(" ");
        for (String checker : checkers.toString().split("")) {
            for (int i = 13; i <= 24; ++i) {
                if (i == 13) {
                    result.append(START_LINE);
                }
                StringBuilder stringBuilderNumbers = new StringBuilder();
                stringBuilderNumbers.append(BLANK_SPACES);
                result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
                if (i == 18) {
                    result.append(END_LINE).append("  ").append(checker).append("  ").append(START_LINE);
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
                    result.append(END_LINE).append(" ".repeat(BAR.length())).append(START_LINE);
                } else if (i == 1) {
                    result.append(END_LINE);
                }
            }
            result.append("\n");
        }

        result.append(LINE_SPACES.repeat(LINE_SPACES_REPEAT)).append(" ".repeat(BAR.length())).append(LINE_SPACES.repeat(LINE_SPACES_REPEAT));
        result.append("\n");

        for (int i = 12; i >= 1; --i) {
            if (i == 12) {
                result.append(" ".repeat(START_LINE.length()));
            }
            StringBuilder stringBuilderNumbers = new StringBuilder();
            stringBuilderNumbers.append(i).append(BLANK_SPACES);
            result.append(stringBuilderNumbers, 0, TEXT_FORMAT_OFFSET);
            if (i == 7) {
                result.append(END_LINE).append(BAR).append(START_LINE);
            } else if (i == 1) {
                result.append(" ".repeat(END_LINE.length()));
            }
        }
        result.append("\n");

        return result.toString();
    }
}
