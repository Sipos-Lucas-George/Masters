package tests;

import scheduler.Event;
import scheduler.EventScheduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class RealLifeScenarioCSVTest {
    public static void main(String[] args) {
        EventScheduler scheduler = new EventScheduler();
        String csvFile = "/events.csv";
        String line;
        String delimiter = ",";
        int lineNumber = 1; // Track of CSV line numbers for debugging

        // Read the CSV file and schedule events
        try (InputStream is = RealLifeScenarioCSVTest.class.getResourceAsStream(csvFile)) {
            if (is == null) {
                System.err.println("Could not find events.csv. Check file location!");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            br.readLine(); // Skip header line

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] data = line.split(delimiter, 2);

                // handle any malformed CSV rows
                if (data.length < 2) {
                    System.err.println("Malformed CSV at line " + lineNumber + ": " + line);
                    continue;
                }

                int timestamp;
                try {
                    timestamp = Integer.parseInt(data[0].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid timestamp at line " + lineNumber + ": " + data[0]);
                    continue;
                }

                String description = data[1].trim();

                scheduler.scheduleEvent(timestamp, description);
            }
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
            return;
        }

        System.out.println("Processing events from CSV file:");

        List<Event> processedEvents = scheduler.runScheduler(0); // Process all scheduled events

        // Simple verification: ensure events are sorted by ascending timestamps
        int previousTimestamp = Integer.MIN_VALUE;

        for (Event event : processedEvents) {
            System.out.println(event);

            // Basic assertion check
            if (event.getTimestamp() < previousTimestamp) {
                System.err.println("Error: Events not processed in correct order.");
                return;
            }
            previousTimestamp = event.getTimestamp();
        }

        System.out.println("All events processed correctly.");
    }
}