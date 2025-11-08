package route_optimisation_logistics;

import adt.Graph;

public class LogisticsNetwork {
    private final Graph<Location> graph;

    public LogisticsNetwork() {
        this.graph = new Graph<>(false, true); // Undirected, weighted
    }

    public void addLocation(String name) {
        graph.addVertex(new Location(name));
    }

    public void connectLocations(String from, String to, double distance) {
        Location l1 = new Location(from);
        Location l2 = new Location(to);
        graph.addEdge(l1, l2, distance);
    }

    public Graph<Location> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
    	return graph.toString();
    }
}
