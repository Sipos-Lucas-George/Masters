package model;

import jdk.jfr.Description;

public class Patient {
    public String firstName;
    protected int age;
    @Description("Weight specified in kg")
    private double weight;
    private final String lastName;

    public Patient() {
        this.firstName = "";
        this.age = 0;
        this.weight = 0;
        this.lastName = "";
    }

    public Patient(String name, int age, double weight, String lastName) {
        this.firstName = name;
        this.age = age;
        this.weight = weight;
        this.lastName = lastName;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    private String getLastName() {
        return lastName;
    }

    private double convertWeightToPounds() {
        return Math.round(weight * 2.2 * 100.0) / 100.0;
    }

    private String printPatient() {
        return firstName + " " + lastName + ": " + age + " yo " + weight + "kg";
    }

    private static String printPatient(Patient patient) {
        return patient.firstName + " " + patient.lastName + " " + patient.age + " yo " + patient.weight + "kg";
    }

    @Override
    public String toString() {
        return firstName + "," + age + "," + weight + "," + lastName;
    }
}
