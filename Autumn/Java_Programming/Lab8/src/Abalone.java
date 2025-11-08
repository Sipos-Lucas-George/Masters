import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Abalone {
    public static final int Male = 0;
    public static final int Female = 1;
    public static final int Infant = 2;

    private int sex;
    private double length;
    private double diameter;
    private double weight;
    private int age;

    public Abalone(int sex, double length, double diameter, double weight, int age) {
        validateSex(sex);
        validatePositive(length, "length");
        validatePositive(diameter, "diameter");
        validatePositive(weight, "weight");
        validatePositive(age, "age");

        this.sex = sex;
        this.length = length;
        this.diameter = diameter;
        this.weight = weight;
        this.age = age;
    }

    private void validateSex(int sex) {
        if (sex < 0 || sex > 2) {
            throw new IllegalArgumentException("Sex should be between 0 and 2");
        }
    }

    private void validatePositive(double value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be negative");
        }
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        validateSex(sex);
        this.sex = sex;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        validatePositive(length, "length");
        this.length = length;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        validatePositive(diameter, "diameter");
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        validatePositive(weight, "weight");
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        validatePositive(age, "age");
        this.age = age;
    }

    public String getSexString() {
        return switch (sex) {
            case 0 -> "Male";
            case 1 -> "Female";
            case 2 -> "Infant";
            default -> throw new IllegalArgumentException("Unexpected value: " + sex);
        };
    }

    public static ArrayList<Abalone> read(File file) throws IOException {
        ArrayList<Abalone> abalones = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return abalones;
        }

        String line;
        while ((line = reader.readLine()) != null) {
            int sex, age;
            double length, diameter, weight;

            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            String sexString = tokenizer.nextToken();
            switch (sexString) {
                case "M" -> sex = 0;
                case "F" -> sex = 1;
                case "I" -> sex = 2;
                default -> {
                    System.out.println("Unknown sex: " + sexString);
                    continue;
                }
            }
            try {
                length = Double.parseDouble(tokenizer.nextToken());
                diameter = Double.parseDouble(tokenizer.nextToken());
                weight = Double.parseDouble(tokenizer.nextToken());
                age = Integer.parseInt(tokenizer.nextToken());
            } catch (NumberFormatException e) {
                System.out.println("Invalid abalone: " + e.getMessage());
                continue;
            }
            try {
                abalones.add(new Abalone(sex, length, diameter, weight, age));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid abalone: " + e.getMessage());
            }
        }
        return abalones;
    }

    @Override
    public String toString() {
        return "Abalone (" + getSexString().charAt(0) + "), length=" + length +
                ", diameter=" + diameter + ", weight=" + weight + ", age=" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abalone abalone = (Abalone) o;
        return sex == abalone.sex && Double.compare(length, abalone.length) == 0
                && Double.compare(diameter, abalone.diameter) == 0
                && Double.compare(weight, abalone.weight) == 0 && age == abalone.age;
    }

    public static void main(String[] args) throws IOException {
        File f = new File(System.getProperty("user.dir") + "/src/abalone/abalone-full.csv");
        ArrayList<Abalone> a = Abalone.read(f);
        for (Abalone abalone : a) {
            System.out.println(abalone);
        }

        File f1 = new File(System.getProperty("user.dir") + "/src/a/invalidData6.csv");
        a = Abalone.read(f1);
    }
}
