package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    // Reads all bytes from the specified file.
    public static byte[] readFile(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    // Writes the given data to the specified file.
    public static void writeFile(String fileName, byte[] data) {
        try {
            Files.write(Paths.get(fileName), data);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Deletes the specified file.
    public static void deleteFile(String fileName) {
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}