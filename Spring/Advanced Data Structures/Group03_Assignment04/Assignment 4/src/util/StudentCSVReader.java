package util;

import record_system.Student;
import record_system.StudentRecordSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utility class for reading student records from a CSV file.
 *
 * CSV Format:
 * Code,Name,Gender,Age,Address,Phone,Email
 * S001, John Doe, M, 20, 123 Main St, 555-1234, john@example.com
 * S002, Jane Smith, F, 22, 456 Oak Ave, 555-5678, jane@example.com
 * ...
 */
public class StudentCSVReader {

    /**
     * Reads student records from a CSV file and returns a populated StudentRecordSystem.
     * 
     * @param csvFilePath the path to the CSV file
     * @return a StudentRecordSystem with all student records added
     */
    public static StudentRecordSystem loadFromCSV(String csvFilePath) {
        StudentRecordSystem system = new StudentRecordSystem();
        String delimiter = ",";
        int lineNumber = 0;
        
        try (InputStream is = StudentCSVReader.class.getResourceAsStream(csvFilePath)) {
            if (is == null) {
                System.err.println("Error: Could not find " + csvFilePath + ". Check the file location!");
                return system;
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String header = reader.readLine(); // Read header
            lineNumber++;
            if (header == null) {
                System.err.println("Error: CSV file is empty!");
                return system;
            }
            
            String line;
            // Process each subsequent line as a student record
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(delimiter, -1);
                if (parts.length < 7) {
                    System.err.println("Malformed CSV at line " + lineNumber + ": " + line);
                    continue;
                }
                
                // Parse CSV values
                String code = parts[0].trim();
                String name = parts[1].trim();
                // "M" means male (true), "F" means female (false)
                boolean gender = parts[2].trim().equalsIgnoreCase("M");
                int age;
                try {
                    age = Integer.parseInt(parts[3].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid age at line " + lineNumber + ": " + parts[3]);
                    continue;
                }
                String address = parts[4].trim();
                String phone = parts[5].trim();
                String email = parts[6].trim();
                
                // Create a Student object and add it to the record system using the unique code.
                Student student = new Student(name, gender, age, address, phone, email);
                system.addStudent(code, student);
            }
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
        
        return system;
    }
}