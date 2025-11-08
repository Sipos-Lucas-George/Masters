package huffman;

import algorithm.HuffmanTree;
import util.FrequencyAnalyser;
import util.FileUtils;
import util.BinaryUtils;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.ByteArrayOutputStream;

public class HuffmanCompressor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n----- MAIN MENU -----");
            System.out.println("Enter C to compress");
            System.out.println("Enter D to decompress");
            System.out.println("Enter Q to quit");
            String action = scanner.nextLine().trim();
            if (action.equalsIgnoreCase("C")) {
                compressMenu(scanner);
            } else if (action.equalsIgnoreCase("D")) {
                decompressMenu(scanner);
            } else if (action.equalsIgnoreCase("Q")) {
                exit = true;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Exiting program...");
    }

    private static void compressMenu(Scanner scanner) {
        File directory = new File("res");
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("No .txt files found in the res directory.");
            return;
        }
        System.out.println("\nSelect a .txt file to compress:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }
        int choice = getFileChoice(scanner, files.length);
        if (choice == -1) {
            return;
        }
        String inputFile = "res/" + files[choice - 1].getName();
        compressFile(inputFile);
        postOperationMenu(scanner);
    }

    private static void decompressMenu(Scanner scanner) {
        File directory = new File("res");
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".bin"));
        if (files == null || files.length == 0) {
            System.out.println("No .bin files found in the res directory.");
            return;
        }
        System.out.println("\nSelect a .bin file to decompress:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }
        int choice = getFileChoice(scanner, files.length);
        if (choice == -1) {
            return;
        }
        String inputFile = "res/" + files[choice - 1].getName();
        decompressFile(inputFile);
        postOperationMenu(scanner);
    }

    private static int getFileChoice(Scanner scanner, int max) {
        int choice = -1;
        while (true) {
            System.out.print("Enter your selection (1-" + max + "): ");
            String line = scanner.nextLine().trim();
            try {
                choice = Integer.parseInt(line);
                if (choice < 1 || choice > max) {
                    System.out.println("Invalid selection. Please choose a number between 1 and " + max + ".");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    private static void postOperationMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nPress M to return to the main menu or Q to quit:");
            String option = scanner.nextLine().trim();
            if (option.equalsIgnoreCase("M")) {
                break;
            } else if (option.equalsIgnoreCase("Q")) {
                System.exit(0);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void compressFile(String fileName) {
        long startTime = System.nanoTime();
        byte[] fileData = FileUtils.readFile(fileName);
        if (fileData == null || fileData.length == 0) {
            System.out.println("No data found in " + fileName);
            return;
        }
        // Read text and preserve all characters (including linebreaks)
        String text = new String(fileData, StandardCharsets.UTF_8);
        fileData = text.getBytes(StandardCharsets.UTF_8);

        // Get freq. map (includes all bytes)
        Map<Byte, Integer> frequencies = FrequencyAnalyser.getFrequencies(fileData);
        System.out.println("\nByte Frequency Count:");
        frequencies.forEach((key, value) -> {
            int unsignedByte = key & 0xFF;
            char ch = (char) unsignedByte;
            System.out.println(String.format("%c (0x%02X) : %d", ch, unsignedByte, value));
        });
        System.out.println();

        // Build Huffman tree using the freq. map
        HuffmanTree<Byte> huffmanTree = new HuffmanTree<>(frequencies);
        huffmanTree.printLevelOrder();

        // Generate Huffman codes
        Map<Byte, String> codes = huffmanTree.generateCodes();
        System.out.println("Huffman Codes:");
        codes.forEach((key, value) -> {
            int unsignedByte = key & 0xFF;
            char ch = (char) unsignedByte;
            System.out.println(String.format("%c (0x%02X) : %s", ch, unsignedByte, value));
        });
        System.out.println();

        // Encode file data using Huffman codes to obtain a binary string
        StringBuilder encodedBuilder = new StringBuilder();
        for (byte b : fileData) {
            encodedBuilder.append(codes.get(b));
        }
        String encodedString = encodedBuilder.toString();
        System.out.println("Encoded Binary String:");
        System.out.println(encodedString);
        System.out.println();

        // Create header using the HuffmanHeader class
        byte[] headerBytes = HuffmanHeader.createHeader(frequencies, encodedString.length());

        // Convert encoded string to true binary byte array
        byte[] encodedBytes = BinaryUtils.binaryStringToByteArray(encodedString);
        byte[] outputContent = new byte[headerBytes.length + encodedBytes.length];
        System.arraycopy(headerBytes, 0, outputContent, 0, headerBytes.length);
        System.arraycopy(encodedBytes, 0, outputContent, headerBytes.length, encodedBytes.length);

        // Write to .bin file and delete original .txt file
        String compressedFileName = fileName.substring(0, fileName.lastIndexOf(".txt")) + "-compressed.bin";
        FileUtils.writeFile(compressedFileName, outputContent);
        FileUtils.deleteFile(fileName);
        long endTime = System.nanoTime();
        System.out.println("Compressed file has been written to: " + compressedFileName);
        System.out.println("Compression time: " + ((endTime - startTime) / 1000000.0) + " ms");
    }

    private static void decompressFile(String compressedFileName) {
        long startTime = System.nanoTime();
        byte[] fileData = FileUtils.readFile(compressedFileName);
        if (fileData == null || fileData.length == 0) {
            System.out.println("No data found in " + compressedFileName);
            return;
        }
        // Parse the header to get frequency map, bit length, and header length
        HuffmanHeader headerData = HuffmanHeader.parseHeader(fileData);
        int headerLength = headerData.getHeaderByteLength();
        int bitLength = headerData.getBitLength();
        Map<Byte, Integer> frequencies = headerData.getFrequencies();

        // Extract the encoded bytes (after the header)
        byte[] encodedBytes = new byte[fileData.length - headerLength];
        System.arraycopy(fileData, headerLength, encodedBytes, 0, encodedBytes.length);
        // Convert the binary data back into the encoded bit string using the stored bit length
        String encodedString = BinaryUtils.byteArrayToBinaryString(encodedBytes, bitLength);

        // Build Huffman tree using the frequency map
        HuffmanTree<Byte> huffmanTree = new HuffmanTree<>(frequencies);
        HuffmanNode<Byte> root = huffmanTree.getRoot();

        // Decode the encoded bit string using the Huffman tree
        ByteArrayOutputStream decodedBytes = new ByteArrayOutputStream();

        // Check for a single-node tree (only one unique symbol)
        if (root.isLeaf()) {
            int count = frequencies.get(root.symbol);
            for (int i = 0; i < count; i++) {
                decodedBytes.write(root.symbol.byteValue());
            }
        } else {
            HuffmanNode<Byte> current = root;
            for (int i = 0; i < encodedString.length(); i++) {
                char bit = encodedString.charAt(i);
                current = (bit == '0') ? current.left : current.right;
                if (current.isLeaf()) {
                    decodedBytes.write(current.symbol.byteValue());
                    current = root;
                }
            }
        }
        
        // Write decompressed data to a .txt file and delete the .bin file
        String outputFileName = compressedFileName.replace("-compressed.bin", ".txt");
        FileUtils.writeFile(outputFileName, decodedBytes.toByteArray());
        FileUtils.deleteFile(compressedFileName);
        long endTime = System.nanoTime();
        System.out.println("Decompressed file has been written to: " + outputFileName);
        System.out.println("Decompression time: " + ((endTime - startTime) / 1000000.0) + " ms");
    }
}