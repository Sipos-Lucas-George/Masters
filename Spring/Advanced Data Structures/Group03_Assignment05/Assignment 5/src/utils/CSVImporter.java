package utils;

import route_optimisation_logistics.LogisticsNetwork;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVImporter {

    /**
     * Imports edges from a CSV file into the given LogisticsNetwork.
     * Expects the CSV file to have a header line and rows with the format:
     * City1,City2,Distance
     *
     * @param csvFile the path to the CSV file
     * @param network the LogisticsNetwork to update
     */
    public static void importEdges(String csvFile, LogisticsNetwork network) {
        String line;
        String delimiter = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header line.
            br.readLine();
            // Process each subsequent line.
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(delimiter);
                if (parts.length < 3) continue; // Skip invalid lines

                String city1 = parts[0].trim();
                String city2 = parts[1].trim();
                double distance = Double.parseDouble(parts[2].trim());

                // Connect the two cities in the network.
                network.connectLocations(city1, city2, distance);
            }
        } catch (IOException e) {
            System.err.println("Error reading the dataset file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}