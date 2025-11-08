package tests;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import scheduler.Event;
import scheduler.EventScheduler;

public class DynamicArrivalTest {
   public DynamicArrivalTest() {
   }

   @Test
   public void testDynamicEventArrival() {
      EventScheduler scheduler = new EventScheduler();
      scheduler.scheduleEvent(10, "Event A");
      scheduler.scheduleEvent(20, "Event B");
      List<Event> batch1 = scheduler.runScheduler(1);
      Assert.assertEquals(1L, (long) batch1.size());
      Assert.assertEquals(10L, (long) ((Event) batch1.get(0)).getTimestamp());
      Assert.assertEquals("Event A", ((Event) batch1.get(0)).getDescription());
      scheduler.scheduleEvent(5, "Event C");
      Assert.assertEquals(5L, (long) scheduler.getNextEvent().getTimestamp());
      Assert.assertEquals("Event C", scheduler.getNextEvent().getDescription());
      List<Event> batch2 = scheduler.runScheduler(0);
      Assert.assertEquals(2L, (long) batch2.size());
      Assert.assertEquals(5L, (long) ((Event) batch2.get(0)).getTimestamp());
      Assert.assertEquals("Event C", ((Event) batch2.get(0)).getDescription());
      Assert.assertEquals(20L, (long) ((Event) batch2.get(1)).getTimestamp());
      Assert.assertEquals("Event B", ((Event) batch2.get(1)).getDescription());
      Assert.assertFalse(scheduler.hasEvents());
   }
}