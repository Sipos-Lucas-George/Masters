package tests;

import record_system.Student;
import record_system.StudentRecordSystem;

/**
 * Stress test for the StudentRecordSystem.
 * Inserts a large number of student records and performs lookups to verify performance and correctness.
 */
public class StudentRecordStressTest {
    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        
        int numRecords = 1_000_000;
        System.out.println("Adding " + numRecords + " student records...");
        // Add a large number of student records
        for (int i = 0; i < numRecords; i++) {
            String code = "S" + i;
            Student student = new Student(
                    "Student" + i, 
                    (i % 2 == 0),           // Even-indexed as male, odd-indexed as female
                    18 + (i % 10),          // Age between 18 and 27
                    "Address" + i, 
                    "Phone" + i, 
                    "email" + i + "@example.com"
            );
            system.addStudent(code, student);
        }
        
        System.out.println("Total Students Added: " + system.getTotalStudents());
        
        // Perform a series of lookups and measure the time taken
        System.out.println("Starting lookup stress test...");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numRecords; i += 10000) {
            String code = "S" + i;
            Student student = system.findStudent(code);
            if (student == null) {
                System.err.println("Error: Student with code " + code + " not found!");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Lookup stress test completed in " + (endTime - startTime) + " ms.");
    }
}