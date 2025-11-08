package scheduler;

import java.util.ArrayList;
import java.util.List;

import adt.Heap;

public class EventScheduler {
	private Heap<Event> eventHeap;

	public EventScheduler() {
		this.eventHeap = new Heap<>();
	}

	// Add a new event
	public void scheduleEvent(int timestamp, String description) {
		Event event = new Event(timestamp, description);
		eventHeap.insert(event);
	}

	// Process up to k events (if k <= 0, process all)
	public List<Event> runScheduler(int k) {
		List<Event> executedEvents = new ArrayList<>();
		int count = 0;

		while (!eventHeap.isEmpty() && (k <= 0 || count < k)) {
			executedEvents.add(eventHeap.popMin());
			count++;
		}

		return executedEvents;
	}

	// Get the most recent event
	public Event getNextEvent() {
		return this.eventHeap.peek();
	}

	// Check if there are any remaining events
	public boolean hasEvents() {
		return !eventHeap.isEmpty();
	}
}