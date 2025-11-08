package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameConstants {
    public static final char[] RANKS = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    public static final ArrayList<Character> SUITS = new ArrayList<>(Arrays.asList('S', 'H', 'C', 'D'));
    public static final int NUMBER_OF_RANKS = 13;
    public static final int NUMBER_OF_LANES = 7;
    public static final int NUMBER_OF_FOUNDATIONS = 4;
    public static final String COMMAND_REGEX = "^(([P1-7][SHCD1-7])|([SHCD][1-7])|([1-7]{2}([1-9]|(1[0-3]))))$";
    public static final Map<Character, Character> SYMBOL_SUIT_MAP = Map.of(
            'S', '♠',
            'H', '♥',
            'C', '♣',
            'D', '♦'
    );
    public static final Map<Character, Character> NEXT_RANK_MAP;

    static {
        NEXT_RANK_MAP = new HashMap<>();
        for (int i = 0; i < RANKS.length - 1; ++i) {
            NEXT_RANK_MAP.put(RANKS[i], RANKS[i + 1]);
        }
    }

    public static final Map<Character, Integer> SUITS_MAP = Map.of(
            'S', 0,
            'H', 1,
            'C', 2,
            'D', 3
    );

    public static void main(String[] args) {
        System.out.println(NEXT_RANK_MAP.toString());
    }
}
