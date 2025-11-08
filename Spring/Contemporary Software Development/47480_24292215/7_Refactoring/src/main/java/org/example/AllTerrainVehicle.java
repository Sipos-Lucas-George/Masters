package org.example;

public class AllTerrainVehicle extends Vehicle {

    public AllTerrainVehicle(String model) {
        super(model);
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // Bonus point for more than 1 day rental
        return (daysRented > 1) ? 2 : 1;
    }
}