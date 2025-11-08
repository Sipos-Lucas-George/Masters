package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import record_system.Student;
import record_system.StudentRecordSystem;

public class StudentRecordSystemTest {

    private StudentRecordSystem recordSystem;

    @BeforeEach
    public void setUp() {
        recordSystem = new StudentRecordSystem();
    }

    @Test
    public void testAddAndFindStudent() {
        Student student = new Student("Alice", false, 20, "123 Main St", "555-0101", "alice@example.com");
        recordSystem.addStudent("S001", student);
        
        Student found = recordSystem.findStudent("S001");
        assertNotNull(found, "Student S001 should be found after adding.");
        assertEquals("Alice", found.name);
        assertEquals(20, found.age);
        assertEquals("alice@example.com", found.email);
        assertEquals(1, recordSystem.getTotalStudents());
    }
    
    @Test
    public void testUpdateStudentRecord() {
        Student student1 = new Student("Bob", true, 22, "456 Elm St", "555-0202", "bob@example.com");
        recordSystem.addStudent("S002", student1);
        
        // Add another record with the same code, which should update the existing entry.
        Student student2 = new Student("Bobby", true, 23, "789 Oak St", "555-0303", "bobby@example.com");
        recordSystem.addStudent("S002", student2);
        
        Student found = recordSystem.findStudent("S002");
        assertNotNull(found, "Student S002 should be found after update.");
        assertEquals("Bobby", found.name);
        assertEquals(23, found.age);
        assertEquals("bobby@example.com", found.email);
        // Total students remains one because the record was updated.
        assertEquals(1, recordSystem.getTotalStudents());
    }
    
    @Test
    public void testRemoveStudent() {
        Student student = new Student("Charlie", true, 21, "321 Maple Ave", "555-0404", "charlie@example.com");
        recordSystem.addStudent("S003", student);
        assertEquals(1, recordSystem.getTotalStudents());
        
        Student removed = recordSystem.removeStudent("S003");
        assertNotNull(removed, "Removal should return the removed student.");
        assertEquals("Charlie", removed.name);
        assertEquals(0, recordSystem.getTotalStudents());
        assertNull(recordSystem.findStudent("S003"), "After removal, student S003 should not be found.");
    }
    
    @Test
    public void testRemoveNonExistentStudent() {
        Student removed = recordSystem.removeStudent("S999");
        assertNull(removed, "Removing a non-existent student should return null.");
        assertEquals(0, recordSystem.getTotalStudents());
    }
    
    @Test
    public void testMultipleAdditionsAndRemovals() {
        // Add several students
        for (int i = 1; i <= 5; i++) {
            recordSystem.addStudent("S00" + i, new Student("Student" + i, i % 2 == 0, 18 + i,
                    "Address" + i, "555-0" + i, "student" + i + "@example.com"));
        }
        assertEquals(5, recordSystem.getTotalStudents());
        
        // Remove two records
        Student removed1 = recordSystem.removeStudent("S002");
        Student removed2 = recordSystem.removeStudent("S004");
        assertNotNull(removed1);
        assertNotNull(removed2);
        assertEquals(3, recordSystem.getTotalStudents());
        assertNull(recordSystem.findStudent("S002"));
        assertNull(recordSystem.findStudent("S004"));
        
        // Verify remaining records are intact
        assertNotNull(recordSystem.findStudent("S001"));
        assertNotNull(recordSystem.findStudent("S003"));
        assertNotNull(recordSystem.findStudent("S005"));
    }
    
    @Test
    public void testStressStudentRecordSystem() {
        int numStudents = 100_000;
        for (int i = 0; i < numStudents; i++) {
            String code = "S" + i;
            Student student = new Student("Student" + i, (i % 2 == 0), 18 + (i % 5),
                    "Address" + i, "555-" + i, "student" + i + "@example.com");
            recordSystem.addStudent(code, student);
        }
        assertEquals(numStudents, recordSystem.getTotalStudents(), "Total student count should match number inserted.");
        
        // Perform periodic lookups to verify correctness.
        for (int i = 0; i < numStudents; i += 10000) {
            Student found = recordSystem.findStudent("S" + i);
            assertNotNull(found, "Student S" + i + " should be found.");
            assertEquals("Student" + i, found.name);
        }
        
        // Remove all entries and verify that the record system is empty.
        for (int i = 0; i < numStudents; i++) {
            recordSystem.removeStudent("S" + i);
        }
        assertEquals(0, recordSystem.getTotalStudents(), "After removals, total student count should be zero.");
    }
}