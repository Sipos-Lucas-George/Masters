package route_optimisation_logistics;

import adt.Graph;
import java.util.*;

public class Dijkstra {

    public static <T> Map<T, Double> shortestPaths(Graph<T> graph, T source) {
        Map<T, Double> dist = new HashMap<>();
        PriorityQueue<Map.Entry<T, Double>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Set<T> visited = new HashSet<>();

        for (T vertex : graph.getVertices()) {
            dist.put(vertex, Double.POSITIVE_INFINITY);
        }
        dist.put(source, 0.0);
        pq.add(new AbstractMap.SimpleEntry<>(source, 0.0));

        while (!pq.isEmpty()) {
            T current = pq.poll().getKey();
            if (!visited.add(current)) continue;

            for (T neighbor : graph.getNeighbors(current)) {
                double newDist = dist.get(current) + graph.getWeight(current, neighbor);
                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    pq.add(new AbstractMap.SimpleEntry<>(neighbor, newDist));
                }
            }
        }

        return dist;
    }

    // Tracks predecessors for path reconstruction
    public static <T> DijkstraResult<T> shortestPathsWithPredecessors(Graph<T> graph, T source) {
        Map<T, Double> dist = new HashMap<>();
        Map<T, T> prev = new HashMap<>();
        PriorityQueue<Map.Entry<T, Double>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Set<T> visited = new HashSet<>();

        for (T vertex : graph.getVertices()) {
            dist.put(vertex, Double.POSITIVE_INFINITY);
        }
        dist.put(source, 0.0);
        pq.add(new AbstractMap.SimpleEntry<>(source, 0.0));

        while (!pq.isEmpty()) {
            T current = pq.poll().getKey();
            if (!visited.add(current)) continue;

            for (T neighbor : graph.getNeighbors(current)) {
                double newDist = dist.get(current) + graph.getWeight(current, neighbor);
                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    prev.put(neighbor, current);
                    pq.add(new AbstractMap.SimpleEntry<>(neighbor, newDist));
                }
            }
        }

        return new DijkstraResult<>(dist, prev);
    }
}