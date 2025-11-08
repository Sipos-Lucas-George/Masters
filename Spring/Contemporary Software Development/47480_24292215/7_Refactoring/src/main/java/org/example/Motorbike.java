package org.example;

public class Motorbike extends Vehicle {

    public Motorbike(String model) {
        super(model);
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}