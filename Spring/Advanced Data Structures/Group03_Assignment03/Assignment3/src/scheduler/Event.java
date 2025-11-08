package scheduler;

public class Event implements Comparable<Event> {
    private int timestamp;  // Time when the event occurs
    private String description;  // Description of the event
    public static int eventCounter = 0; // Insertion order of the event
    private int id; // Unique insertion ID

    public Event(int timestamp, String description) {
        this.timestamp = timestamp;
        this.description = description;
        this.id = eventCounter++;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Event other) {
        int timeComparison = Integer.compare(this.timestamp, other.timestamp);
        return (timeComparison != 0) ? timeComparison : Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Event at " + timestamp + ": " + description;
    }
}