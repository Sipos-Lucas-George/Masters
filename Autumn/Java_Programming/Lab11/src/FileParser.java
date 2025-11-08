import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileParser extends Thread {

    private File file;
    private int lines = 0;
    private int words = 0;
    private int totalWordsLength = 0;
    private int maxWordLength = Integer.MIN_VALUE;

    public FileParser(File f) {
        super();
        if (f == null) {
            throw new IllegalArgumentException("File is null");
        }

        if (f.isDirectory()) {
            throw new IllegalArgumentException("File is a directory");
        }
        file = f;
    }

    public void run() {
        parse();
    }

    public void parse() {

        try(Scanner s = new Scanner(file)) {

            String line;

            while(s.hasNextLine()) {
                line = s.nextLine();
                processLine(line);
            }

            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processLine(String line) {
        lines++;
        String[] tokens = line.split("\\s+");
        for (String s: tokens) {
            words++;
            processWord(s);
        }

    }

    private void processWord(String s) {
        int length = s.trim().length();
        totalWordsLength += length;

        if (length > maxWordLength) {
            maxWordLength = length;
        }
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getWords() {
        return words;
    }

    public int getLines() {
        return lines;
    }

    public double getAverageWordLength() {
        return (double)totalWordsLength / (double)lines;
    }

    @Override
    public String toString() {
        return "FileParser{" +
                "lines=" + lines +
                ", words=" + words +
                ", totalWordsLength=" + totalWordsLength +
                ", maxWordLength=" + maxWordLength +
                ", averageWordLength=" + getAverageWordLength() +
                '}';
    }
}
