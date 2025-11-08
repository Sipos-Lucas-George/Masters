package utils;

import java.util.ArrayList;
import java.util.List;

public class CityGenerator {
    private static final int MAX_LETTER_CITIES = 26;

    public static List<String> generateCities(int n, String naming) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of cities must be positive.");
        }

        List<String> cities = new ArrayList<>();
        if ("letter".equalsIgnoreCase(naming) && n <= MAX_LETTER_CITIES) {
            for (char c = 'A'; c < 'A' + n; c++) {
                cities.add(String.valueOf(c));
            }
        } else {
            for (int i = 1; i <= n; i++) {
                cities.add(String.format("City%02d", i));
            }
        }
        return cities;
    }
}