package route_optimisation_logistics;

import java.util.Map;

public class DijkstraResult<T> {
    private final Map<T, Double> distances;
    private final Map<T, T> predecessors;

    public DijkstraResult(Map<T, Double> distances, Map<T, T> predecessors) {
        this.distances = distances;
        this.predecessors = predecessors;
    }

    public Map<T, Double> getDistances() {
        return distances;
    }

    public Map<T, T> getPredecessors() {
        return predecessors;
    }
}