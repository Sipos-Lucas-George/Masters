package adt;

import java.util.*;

public class Graph<T> {
    private final boolean isDirected;
    private final boolean isWeighted;

    // Only one of these will be used based on isWeighted
    private final Map<T, Set<T>> unweightedAdjList;
    private final Map<T, Map<T, Double>> weightedAdjList;

	public Graph(boolean isDirected, boolean isWeighted) {
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        this.unweightedAdjList = isWeighted ? null : new HashMap<>();
        this.weightedAdjList = isWeighted ? new HashMap<>() : null;
    }

    // Add a vertex
    public void addVertex(T vertex) {
        if (isWeighted) {
            weightedAdjList.putIfAbsent(vertex, new HashMap<>());
        } else {
            unweightedAdjList.putIfAbsent(vertex, new HashSet<>());
        }
    }

    // Add an edge (weighted)
    public void addEdge(T from, T to, double weight) {
        if (!isWeighted) {
        	addEdge(from, to);
            return;
        }
        addVertex(from);
        addVertex(to);
        weightedAdjList.get(from).put(to, weight);
        if (!isDirected) {
            weightedAdjList.get(to).put(from, weight);
        }
    }

    // Add edge (unweighted)
    public void addEdge(T from, T to) {
        if (isWeighted) {
            addEdge(from, to, 1.0);
            return;
        }
        addVertex(from);
        addVertex(to);
        unweightedAdjList.get(from).add(to);
        if (!isDirected) {
            unweightedAdjList.get(to).add(from);
        }
    }

    public void removeEdge(T from, T to) {
        if (isWeighted) {
            if (weightedAdjList.containsKey(from)) weightedAdjList.get(from).remove(to);
            if (!isDirected && weightedAdjList.containsKey(to)) weightedAdjList.get(to).remove(from);
        } else {
            if (unweightedAdjList.containsKey(from)) unweightedAdjList.get(from).remove(to);
            if (!isDirected && unweightedAdjList.containsKey(to)) unweightedAdjList.get(to).remove(from);
        }
    }

    public void removeVertex(T vertex) {
        if (isWeighted) {
            weightedAdjList.remove(vertex);
            for (Map<T, Double> neighbors : weightedAdjList.values()) {
                neighbors.remove(vertex);
            }
        } else {
            unweightedAdjList.remove(vertex);
            for (Set<T> neighbors : unweightedAdjList.values()) {
                neighbors.remove(vertex);
            }
        }
    }

    public Set<T> getNeighbors(T vertex) {
        if (isWeighted) {
            return weightedAdjList.getOrDefault(vertex, Map.of()).keySet();
        } else {
            return unweightedAdjList.getOrDefault(vertex, Set.of());
        }
    }

    public boolean hasEdge(T from, T to) {
        if (isWeighted) {
            return weightedAdjList.containsKey(from) && weightedAdjList.get(from).containsKey(to);
        } else {
            return unweightedAdjList.containsKey(from) && unweightedAdjList.get(from).contains(to);
        }
    }

    public double getWeight(T from, T to) {
        if (!isWeighted) throw new UnsupportedOperationException("This is an unweighted graph.");
        return weightedAdjList.getOrDefault(from, Map.of()).getOrDefault(to, Double.POSITIVE_INFINITY);
    }

    public Set<T> getVertices() {
        return isWeighted ? weightedAdjList.keySet() : unweightedAdjList.keySet();
    }

    public int getEdgeCount() {
        int count = 0;
        int selfLoops = 0;

        if (isWeighted) {
            for (var entry : weightedAdjList.entrySet()) {
                T vertex = entry.getKey();
                for (T neighbor : entry.getValue().keySet()) {
                    count++;
                    if (vertex.equals(neighbor)) {
                        selfLoops++;
                    }
                }
            }
        } else {
            for (var entry : unweightedAdjList.entrySet()) {
                T vertex = entry.getKey();
                for (T neighbor : entry.getValue()) {
                    count++;
                    if (vertex.equals(neighbor)) {
                        selfLoops++;
                    }
                }
            }
        }

        if (isDirected) {
            return count;
        }

        // Each undirected edge is counted twice, except self-loops which are counted once
        return (count - selfLoops) / 2 + selfLoops;
    }

    public int getVertexCount() {
        return isWeighted ? weightedAdjList.size() : unweightedAdjList.size();
    }

    public boolean isDirected() {
        return isDirected;
    }

    public boolean isWeighted() {
        return isWeighted;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isWeighted) {
            for (var entry : weightedAdjList.entrySet()) {
                sb.append(entry.getKey()).append(" ->  ");
                for (var neighbor : entry.getValue().entrySet()) {
                    sb.append(neighbor.getKey())
                      .append("(")
                      .append(neighbor.getValue())
                      .append("), ");
                }
                sb.delete(sb.length() - 2, sb.length());
                sb.append("\n");
            }
        } else {
            for (var entry : unweightedAdjList.entrySet()) {
                sb.append(entry.getKey()).append(" ->  ");
                for (var neighbor : entry.getValue()) {
                    sb.append(neighbor).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
