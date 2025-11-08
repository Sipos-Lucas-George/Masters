import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Wine {
    private final double colourIntensity;
    private final double hue;
    private final double ash;
    private final double flavanoids;
    private final double magnesium;
    private final double malicAcid;
    private final String wineType;

    public Wine(double colourIntensity, double hue, double ash, double flavanoids, double magnesium, double malicAcid, String wineType) {
        this.colourIntensity = colourIntensity;
        this.hue = hue;
        this.ash = ash;
        this.flavanoids = flavanoids;
        this.magnesium = magnesium;
        this.malicAcid = malicAcid;
        this.wineType = wineType;
    }

    @Override
    public String toString() {
        return "Wine: [" +
                "colour intensity: " + formatNumber(colourIntensity) +
                ", hue: " + formatNumber(hue) +
                ", ash: " + formatNumber(ash) +
                ", flavanoids: " + formatNumber(flavanoids) +
                ", magnesium: " + formatNumber(magnesium) +
                ", malic acid: " + formatNumber(malicAcid) +
                ", wine: " + wineType +
                ']';
    }

    private String formatNumber(double value) {
        return (value == (int) value) ? String.valueOf((int) value) : String.valueOf(value);
    }

    public static ArrayList<Wine> read(File file) throws IOException {
        if (file == null || !file.isFile() || !file.exists() || !file.isFile()) {
            throw new IllegalArgumentException();
        }
        ArrayList<Wine> wines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            boolean isHeader = true;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                try {
                    String[] parts = line.split(",");
                    if (parts.length != 7) {
                        throw new IllegalArgumentException("Invalid number of fields");
                    }

                    double colourIntensity = parseDoubleWithValidation(parts[0].trim(), "colourIntensity");
                    double hue = parseDoubleWithValidation(parts[1].trim(), "hue");
                    double ash = parseDoubleWithValidation(parts[2].trim(), "ash");
                    double flavanoids = parseDoubleWithValidation(parts[3].trim(), "flavanoids");
                    double magnesium = parseDoubleWithValidation(parts[4].trim(), "magnesium");
                    double malicAcid = parseDoubleWithValidation(parts[5].trim(), "malicAcid");
                    String wineType = parseStringWithValidation(parts[6].trim().replaceAll("\"", ""));

                    Wine wine = new Wine(colourIntensity, hue, ash, flavanoids, magnesium, malicAcid, wineType);
                    wines.add(wine);
                } catch (Exception e) {
                    System.out.printf("Error in line: %s %s%n", line, e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found");
        }

        return wines;
    }

    private static double parseDoubleWithValidation(String value, String key) {
        try {
            double v = Double.parseDouble(value);
            if (v < 0) {
                throw new IllegalArgumentException("invalid value: " + value);
            }
            if (key.equals("malicAcid") && v > 14) {
                throw new IllegalArgumentException("invalid value: " + v);
            }
            return v;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid value: " + value.replaceAll("\"", ""));
        }
    }

    private static String parseStringWithValidation(String value) {
        if (!value.matches("red|white|rose")) {
            throw new IllegalArgumentException("invalid value: " + value);
        }
        return value;
    }

    public static void write(File file, ArrayList<Wine> wines) throws IOException {
        if (file == null || wines == null) {
            throw new IllegalArgumentException();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("colour intensity,hue,ash,flavanoids,magnesium,malic acid,wine");

            for (Wine wine : wines) {
                writer.newLine();
                writer.write(
                        wine.formatNumber(wine.colourIntensity) + "," +
                                wine.formatNumber(wine.hue) + "," +
                                wine.formatNumber(wine.ash) + "," +
                                wine.formatNumber(wine.flavanoids) + "," +
                                wine.formatNumber(wine.magnesium) + "," +
                                wine.formatNumber(wine.malicAcid) + ",\"" +
                                wine.wineType + "\""
                );
            }
        }
    }

    public static void main(String[] args) {
        String name = (int) (Math.random() * 100000) + "-" + System.currentTimeMillis() + ".csv";
        try {
            File f = new File("src/wine_b.csv");
            ArrayList<Wine> a = Wine.read(f);
            Wine.write(new File("src/" + name), a);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


