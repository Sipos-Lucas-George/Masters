package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void saveEdgesToCSV(List<Edge> edges, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("City1,City2,Distance");
            writer.newLine();
            for (Edge edge : edges) {
                writer.write(String.format("%s,%s,%.2f", edge.getCity1(), edge.getCity2(), edge.getDistance()));
                writer.newLine();
            }
            System.out.println("Dataset successfully saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving dataset: " + e.getMessage());
        }
    }
}