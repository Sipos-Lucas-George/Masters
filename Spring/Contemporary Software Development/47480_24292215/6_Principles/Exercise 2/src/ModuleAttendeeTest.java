import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModuleAttendeeTest {
  @Before
  public void setup() {
    john = new ModuleAttendee("John");
    module = new ModuleAttempt("OOP", "COMP1234", Grade.NONE);
    john.addModuleAttempt(module);
  }
  
  @Test
  public void testToString() {
    assertEquals("John took\nCOMP1234:OOP, achieving the grade: NONE", john.toString());
  }

  @Test
  public void testSetGrade() {
    module.setGrade(Grade.PASS);
    assertEquals("John took\nCOMP1234:OOP, achieving the grade: PASS", john.toString());
  }
  
  private ModuleAttendee john;
  private ModuleAttempt module;
}
