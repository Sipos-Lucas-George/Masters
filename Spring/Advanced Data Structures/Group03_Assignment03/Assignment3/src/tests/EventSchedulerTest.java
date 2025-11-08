package tests;

import org.junit.Test;
import scheduler.Event;
import scheduler.EventScheduler;

import java.util.List;

import static org.junit.Assert.*;

public class EventSchedulerTest {

    @Test
    public void testEmptyScheduler() {
        EventScheduler scheduler = new EventScheduler();
        assertFalse(scheduler.hasEvents());
        Exception exception = assertThrows(IllegalStateException.class, scheduler::getNextEvent);
        assertEquals("Heap is empty", exception.getMessage());
    }

    @Test
    public void testSingleEvent() {
        EventScheduler scheduler = new EventScheduler();
        scheduler.scheduleEvent(100, "Single event");

        assertTrue(scheduler.hasEvents());
        Event nextEvent = scheduler.getNextEvent();
        assertEquals(100, nextEvent.getTimestamp());
        assertEquals("Single event", nextEvent.getDescription());

        List<Event> executed = scheduler.runScheduler(1);
        assertEquals(1, executed.size());
        assertEquals(100, executed.get(0).getTimestamp());

        assertFalse(scheduler.hasEvents());
    }

    @Test
    public void testLargeTimestamp() {
        EventScheduler scheduler = new EventScheduler();
        scheduler.scheduleEvent(Integer.MAX_VALUE, "Max Timestamp Event");
        assertEquals(Integer.MAX_VALUE, scheduler.getNextEvent().getTimestamp());
    }

    @Test
    public void testMultipleEventsOrder() {
        EventScheduler scheduler = new EventScheduler();
        scheduler.scheduleEvent(50, "Event 50");
        scheduler.scheduleEvent(10, "Event 10");
        scheduler.scheduleEvent(20, "Event 20");
        scheduler.scheduleEvent(10, "Event 10-B");

        List<Event> executed = scheduler.runScheduler(0);

        assertEquals(4, executed.size());
        assertEquals(10, executed.get(0).getTimestamp());
        assertEquals("Event 10", executed.get(0).getDescription());
        assertEquals(10, executed.get(1).getTimestamp());
        assertEquals("Event 10-B", executed.get(1).getDescription());
        assertEquals(20, executed.get(2).getTimestamp());
        assertEquals(50, executed.get(3).getTimestamp());
    }

    @Test
    public void testEventSchedulerNegativeTimestamp() {
        EventScheduler scheduler = new EventScheduler();
        scheduler.scheduleEvent(-100, "Negative timestamp event");
        scheduler.scheduleEvent(0, "Zero timestamp event");

        List<Event> executed = scheduler.runScheduler(0);
        assertEquals(-100, executed.get(0).getTimestamp());
        assertEquals(0, executed.get(1).getTimestamp());
    }

    @Test
    public void testBatchProcessing() {
        EventScheduler scheduler = new EventScheduler();
        for (int i = 1; i <= 10; i++) {
            scheduler.scheduleEvent(i, "Event " + i);
        }

        List<Event> batch1 = scheduler.runScheduler(5);
        assertEquals(5, batch1.size());
        assertEquals(1, batch1.get(0).getTimestamp());
        assertEquals(5, batch1.get(4).getTimestamp());

        List<Event> batch2 = scheduler.runScheduler(10);
        assertEquals(5, batch2.size());
        assertEquals(6, batch2.get(0).getTimestamp());
        assertEquals(10, batch2.get(4).getTimestamp());

        assertFalse(scheduler.hasEvents());
    }

    @Test
    public void testSequentialIdenticalEvents() {
        EventScheduler scheduler = new EventScheduler();
        for (int i = 0; i < 5; i++) {
            scheduler.scheduleEvent(100, "Event at 100ms - " + i);
        }

        List<Event> executed = scheduler.runScheduler(0);

        assertEquals(5, executed.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(100, executed.get(i).getTimestamp());
            assertEquals("Event at 100ms - " + i, executed.get(i).getDescription());
        }
    }

    @Test
    public void testRunSchedulerWithNegativeK() {
        EventScheduler scheduler = new EventScheduler();
        scheduler.scheduleEvent(10, "Event 1");
        scheduler.scheduleEvent(5, "Event 2");

        List<Event> events = scheduler.runScheduler(-1);
        assertEquals(2, events.size());
        assertFalse(scheduler.hasEvents());
    }

    @Test
    public void testRunSchedulerLimitK() {
        EventScheduler scheduler = new EventScheduler();
        scheduler.scheduleEvent(10, "Event 1");
        scheduler.scheduleEvent(5, "Event 2");
        scheduler.scheduleEvent(15, "Event 3");

        List<Event> events = scheduler.runScheduler(2);
        assertEquals(2, events.size());
        assertEquals(5, events.get(0).getTimestamp());
        assertEquals(10, events.get(1).getTimestamp());

        assertTrue(scheduler.hasEvents());
        assertEquals(15, scheduler.getNextEvent().getTimestamp());
    }

    @Test
    public void stressTestScheduler() {
        EventScheduler scheduler = new EventScheduler();

        int numEvents = 100_000;
        for (int i = numEvents; i > 0; i--) {
            scheduler.scheduleEvent(i, "Event " + i);
        }

        int processed = 0;
        while (scheduler.hasEvents()) {
            List<Event> events = scheduler.runScheduler(1000);
            processed += events.size();
        }

        assertEquals(numEvents, processed);
        assertFalse(scheduler.hasEvents());
    }
}