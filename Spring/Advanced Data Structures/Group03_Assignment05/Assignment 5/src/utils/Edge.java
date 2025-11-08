package utils;

public class Edge {
    private final String city1;
    private final String city2;
    private final double distance;

    public Edge(String city1, String city2, double distance) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %.2f", city1, city2, distance);
    }
}