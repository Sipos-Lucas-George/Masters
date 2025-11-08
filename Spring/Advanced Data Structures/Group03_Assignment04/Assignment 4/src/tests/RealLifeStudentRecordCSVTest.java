package tests;

import record_system.Student;
import record_system.StudentRecordSystem;
import util.StudentCSVReader;

/**
 * Real-life test that simulates reading student records from a CSV file
 * and performing operations on the StudentRecordSystem.
 */
public class RealLifeStudentRecordCSVTest {
    public static void main(String[] args) {
        // Use the utility class to load the records from the CSV file.
        StudentRecordSystem system = StudentCSVReader.loadFromCSV("/students.csv");
        
        // Output the total number of students added.
        System.out.println("Total Students Added: " + system.getTotalStudents());
        
        // Test lookup: Try to find a student with a known code.
        String testCode = "S001";
        Student foundStudent = system.findStudent(testCode);
        if (foundStudent != null) {
            System.out.println("\nStudent with code " + testCode + " found:");
            System.out.println(foundStudent);
        } else {
            System.out.println("\nStudent with code " + testCode + " not found.");
        }
        
        // Test removal: Remove a student and verify removal.
        String removeCode = "S002";
        Student removed = system.removeStudent(removeCode);
        if (removed != null) {
            System.out.println("\nRemoved student with code " + removeCode + ":");
            System.out.println(removed);
        } else {
            System.out.println("\nNo student with code " + removeCode + " found to remove.");
        }
        
        // Final count after removal.
        System.out.println("\nTotal Students after removal: " + system.getTotalStudents());
    }
}
