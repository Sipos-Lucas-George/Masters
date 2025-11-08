package utils;

import java.util.List;

public class DatasetGeneratorApp {
    private static final String DEFAULT_FILENAME = "dataset.csv";

    public static void main(String[] args) {
        // Configurable parameters
        int numCities = 200;
        double minWeight = 1.0;
        double maxWeight = 100.0;
        int maxExtraEdges = 3;

        // Generate cities and edges
        List<String> cities = CityGenerator.generateCities(numCities, "letter");
        List<Edge> edges = EdgeGenerator.generateEdges(cities, minWeight, maxWeight, maxExtraEdges);

        // Save to CSV file
        CSVExporter.saveEdgesToCSV(edges, DEFAULT_FILENAME);

        // Debugging outputs
        System.out.println("Generated Cities: " + cities);
        System.out.println("Generated Edges:");
        edges.forEach(System.out::println);
    }
}