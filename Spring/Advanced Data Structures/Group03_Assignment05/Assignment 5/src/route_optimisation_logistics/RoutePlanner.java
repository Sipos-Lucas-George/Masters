package route_optimisation_logistics;

import adt.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RoutePlanner {

    private final Graph<Location> graph;

    public RoutePlanner(Graph<Location> graph) {
        this.graph = graph;
    }

    public void findShortestRoute(String fromName, String toName) {
        Location from = new Location(fromName);
        Location to = new Location(toName);

        // Use the new method to get both distances and predecessors.
        DijkstraResult<Location> result = Dijkstra.shortestPathsWithPredecessors(graph, from);
        Map<Location, Double> distances = result.getDistances();
        Map<Location, Location> predecessors = result.getPredecessors();

        double distance = distances.getOrDefault(to, Double.POSITIVE_INFINITY);
        System.out.println("Shortest distance from " + from + " to " + to + ": " + distance);

        if (distance == Double.POSITIVE_INFINITY) {
            System.out.println("No path found from " + from + " to " + to + ".");
            return;
        }

        // Reconstruct the path using the predecessor map.
        List<Location> path = new ArrayList<>();
        for (Location at = to; at != null; at = predecessors.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println("Path: " + path);
    }

    // TODO uncomment this part for example
    // public static void main(String[] args) {
    // LogisticsNetwork network = new LogisticsNetwork();
    //
    // // Add locations, not necessarily needed if you make a connection with them
    ////        network.addLocation("Satu Mare");
////        network.addLocation("Cluj");
////        network.addLocation("Oradea");
////        network.addLocation("Timisoara");
////        network.addLocation("Arad");
    //
    // // Connect them (also creates location if not added)
    // network.connectLocations("Satu Mare", "Cluj", 150);
    // network.connectLocations("Cluj", "Oradea", 60);
    // network.connectLocations("Satu Mare", "Oradea", 120);
    // network.connectLocations("Oradea", "Arad", 110);
    // network.connectLocations("Arad", "Timisoara", 50);
    //
    // System.out.println(network);
    //
    // RoutePlanner planner = new RoutePlanner(network.getGraph());
    // planner.findShortestRoute("Satu Mare", "Timisoara");
    // }
}