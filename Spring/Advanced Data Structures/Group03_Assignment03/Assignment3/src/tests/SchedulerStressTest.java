package tests;

import scheduler.EventScheduler;

public class SchedulerStressTest {
    public static void main(String[] args) {
        EventScheduler scheduler = new EventScheduler();

        int numEvents = 1_000_000;
        for (int i = numEvents; i > 0; i--) {
            scheduler.scheduleEvent(i, "Event number " + i);
        }

        System.out.println("Stress Test Started");
        long start = System.currentTimeMillis();

        while (scheduler.hasEvents()) {
            scheduler.runScheduler(10000); // batch processing
        }

        long end = System.currentTimeMillis();

        System.out.println("Processed " + numEvents + " events in " + (end - start) + " ms.");
    }
}