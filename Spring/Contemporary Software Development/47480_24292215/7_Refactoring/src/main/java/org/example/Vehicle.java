package org.example;

public abstract class Vehicle {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getTitle() {
        return model;
    }

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1; // Default frequent renter points
    }
}