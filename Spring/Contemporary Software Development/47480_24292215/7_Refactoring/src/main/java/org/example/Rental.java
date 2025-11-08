package org.example;

// Represents a rental of a vehicle
public class Rental {
    private Vehicle vehicle;
    private int daysRented;

    public Rental(Vehicle vehicle, int daysRented) {
        this.vehicle = vehicle;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getCharge() {
        return vehicle.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return vehicle.getFrequentRenterPoints(daysRented);
    }
}