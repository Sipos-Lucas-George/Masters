package org.example;

public class HtmlStatementFormatter implements StatementFormatter {

    @Override
    public String format(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("<h1>Rental Record for " + customer.getName() + "</h1><ul>");

        for (Rental rental : customer.getRentals()) {
            double thisAmount = rental.getCharge();
            frequentRenterPoints += rental.getFrequentRenterPoints();

            result.append("<li>")
                    .append(rental.getVehicle().getTitle())
                    .append(": ")
                    .append(thisAmount)
                    .append("</li>");

            totalAmount += thisAmount;
        }

        result.append("</ul><p>Amount owed is ")
                .append(totalAmount)
                .append("</p><p>You earned ")
                .append(frequentRenterPoints)
                .append(" frequent renter points</p>");

        return result.toString();
    }
}
