package tests;

import route_optimisation_logistics.LogisticsNetwork;
import route_optimisation_logistics.RoutePlanner;
import utils.CSVImporter;
import utils.TimerUtil;

public class RealLifeScenarioTest {

    public static void main(String[] args) {
        // Create a new logistics network (undirected, weighted graph)
        LogisticsNetwork network = new LogisticsNetwork();

        // Path to the dataset CSV file.
        String csvFile = "dataset.csv";
        
        // Import edges from the CSV file using the utility class.
        CSVImporter.importEdges(csvFile, network);
        
        // Print the constructed logistics network.
        System.out.println("Logistics Network:");
        System.out.println(network);
        
        // Use RoutePlanner to calculate the shortest route between two locations.
        // Here we assume that the cities "City01" and "City200" exist in the dataset.
        RoutePlanner planner = new RoutePlanner(network.getGraph());
        System.out.println("Calculating shortest route from City01 to City200:");
        
        // Measure the time taken to calculate the shortest route.
        long elapsedTime = TimerUtil.measure(() -> planner.findShortestRoute("City01", "City200"));
        System.out.println("Time taken to calculate shortest route: " + elapsedTime + " ms");
    }
}