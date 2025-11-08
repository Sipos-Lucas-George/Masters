package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EdgeGenerator {
    private static final Random RAND = new Random();

    public static List<Edge> generateEdges(List<String> cities, double minWeight, double maxWeight, int maxExtraEdges) {
        if (cities.size() < 2) {
            throw new IllegalArgumentException("At least two cities are required.");
        }
        if (minWeight >= maxWeight) {
            throw new IllegalArgumentException("minWeight must be less than maxWeight.");
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i < cities.size(); i++) {
            String currentCity = cities.get(i);
            String prevCity = cities.get(i - 1);
            edges.add(new Edge(prevCity, currentCity, randomWeight(minWeight, maxWeight)));

            List<String> possibleExtraCities = cities.subList(0, i - 1);
            Collections.shuffle(possibleExtraCities, RAND);

            int numExtra = RAND.nextInt(Math.min(maxExtraEdges + 1, possibleExtraCities.size() + 1));
            for (int j = 0; j < numExtra; j++) {
                edges.add(new Edge(possibleExtraCities.get(j), currentCity, randomWeight(minWeight, maxWeight)));
            }
        }
        return edges;
    }

    private static double randomWeight(double min, double max) {
        return Math.round((min + (max - min) * RAND.nextDouble()) * 100.0) / 100.0;
    }
}