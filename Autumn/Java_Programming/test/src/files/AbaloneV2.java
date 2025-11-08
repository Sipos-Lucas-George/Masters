package files;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AbaloneV2 implements Serializable {
    private int sex, age;
    private double weight, length, diameter;

    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int INFANT = 2;

    public AbaloneV2(int sex, double weight, double length, double diameter, int age) {

        validateSex(sex);
        validateNumber(weight, "Weight");
        validateNumber(length, "Length");
        validateNumber(diameter, "Diameter");
        validateNumber(age, "Age");

        this.sex = sex;
        this.diameter = diameter;
        this.age = age;
        this.weight = weight;
        this.length = length;
    }

    private void validateSex(int sex) {
        if (sex < 0 || sex > 2) {
            throw new IllegalArgumentException("Sex value inappropriate: " + sex);
        }
    }

    private void validateNumber(double d, String name) {
        if (d < 0) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        validateNumber(age, "Age");
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        validateNumber(weight, "Weight");
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        validateNumber(length, "Length");
        this.length = length;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        validateNumber(diameter, "Diameter");
        this.diameter = diameter;
    }

    public String toString() {
        String type = "";
        switch (getSex()) {
            case 0: type = "M"; break;
            case 1: type = "F"; break;
            default: type = "I";
        }
        //Abalone (M), length=0.35, diameter=0.53, weight=0.64, age=10
        return "Abalone (" + type + "), length=" + getLength() + ", diameter=" +
                getDiameter() + ", weight=" + getWeight() + ", age=" + getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof AbaloneV2)) return false;
        AbaloneV2 abalone = (AbaloneV2) o;
        return sex == abalone.sex &&
                age == abalone.age &&
                Double.compare(abalone.weight, weight) == 0 &&
                Double.compare(abalone.length, length) == 0 &&
                Double.compare(abalone.diameter, diameter) == 0;
    }

    public static ArrayList<AbaloneV2> read(File f) throws IOException {
        ArrayList<AbaloneV2> abalones = new ArrayList<AbaloneV2>();

        BufferedReader in = new BufferedReader(new FileReader(f));
        String line;
        StringTokenizer st;

        String sex;
        int age;
        double weight, length, diameter;

        AbaloneV2 a;
        int s;

        while((line = in.readLine()) != null) {
            System.out.println(line);
            st = new StringTokenizer(line, ",");

            sex = st.nextToken();

            switch (sex) {
                case "M": s = AbaloneV2.MALE; break;
                case "F": s = AbaloneV2.FEMALE; break;
                case "I": s = AbaloneV2.INFANT; break;
                default: throw new IllegalArgumentException("Invalid sex: " + sex);
            }

            weight = Double.parseDouble(st.nextToken());
            length = Double.parseDouble(st.nextToken());
            diameter = Double.parseDouble(st.nextToken());
            age = Integer.parseInt(st.nextToken());

            a = new AbaloneV2(s, weight, length, diameter, age);
            abalones.add(a);
        }

        return abalones;
    }

    public static void main(String[] args) throws IOException {
        File f = new File(System.getProperty("user.dir") + "/src/files/abalone/abalone-short.csv");
        ArrayList<AbaloneV2> a = AbaloneV2.read(f);
        //could comment this out if you wanted to
        for (AbaloneV2 abalone : a) {
            System.out.println(abalone);
        }

        System.out.println("\n\n Starting Serialization\n\n");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream((new File("Abalone.obj"))));
            //write just the first one as an example
            oos.writeObject(a.get(0));
            oos.flush();
            oos.close();

            //read it back in
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Abalone.obj")));
            Object o = ois.readObject();
            if (o instanceof AbaloneV2) {
                AbaloneV2 abalone = (AbaloneV2) o;
                System.out.println(abalone);
            } else {
                throw new RuntimeException("Expected Abalone, got: " + o.getClass().getCanonicalName());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
