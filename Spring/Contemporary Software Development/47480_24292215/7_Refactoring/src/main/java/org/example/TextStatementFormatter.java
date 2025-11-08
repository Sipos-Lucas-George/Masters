package org.example;

public class TextStatementFormatter implements StatementFormatter {

    @Override
    public String format(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        for (Rental rental : customer.getRentals()) {
            double thisAmount = rental.getCharge();
            frequentRenterPoints += rental.getFrequentRenterPoints();

            result.append("\t")
                    .append(rental.getVehicle().getTitle())
                    .append("\t")
                    .append(thisAmount)
                    .append("\n");

            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result.toString();
    }
}
