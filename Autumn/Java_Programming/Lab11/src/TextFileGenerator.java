import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class TextFileGenerator {

    /*
     * Thanks to ChatGPT for this method
     */
    // Define characters to use in the random string
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public static String generateRandomText(int length) {
        StringBuilder randomText = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            randomText.append(CHARACTERS.charAt(randomIndex));
        }

        return randomText.toString();
    }

    //note this will overwrite existing files!
    public static File generateFile(File dir, String name) throws IOException {

        if (dir.isDirectory()) {
            File f = new File(dir, name);
            int lines = RANDOM.nextInt(50);
            int words;

            StringBuilder randomText = new StringBuilder();
            for (int i = 0; i < lines; i++) {
                words = RANDOM.nextInt(20, 50);
                for (int j = 0; j < words; j++) {
                    randomText.append(generateRandomText(RANDOM.nextInt(3, 10))).append(" ");
                }
                randomText.append("\n");
            }

            PrintWriter out = new PrintWriter(new FileWriter(f));
            out.println(randomText.toString());
            out.close();

            return f;
        }

        throw new IOException("Need a directory as input. Provided: " + dir);
    }

    public static ArrayList<File> generateRandomFiles(int count, File dir, String namePrefix) throws IOException {

        if (!dir.isDirectory()) {
            throw new IOException("Provided: " + dir + " is not a directory.");
        }

        ArrayList<File> files = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            files.add(generateFile(dir, namePrefix + i + ".txt"));
        }

        return files;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        File dir = new File("src/files");
        int count = 100;
        ArrayList<File> files = generateRandomFiles(count, dir, "output");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        long start = System.currentTimeMillis();
        ArrayList<FileParser> fps = new ArrayList<>();
        FileParser fp;
        for (File file : files) {
            fp = new FileParser(file);
            fps.add(fp);
            fp.start();
        }

        for (FileParser fileParser : fps) {
            fileParser.join();
            System.out.println(fileParser);
        }

        System.out.println("Total runtime: " + (System.currentTimeMillis() - start));

    }

}
