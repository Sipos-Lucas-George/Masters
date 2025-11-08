import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.*;

public class CustomerTest {

    StatementFormatter statementFormatter = new TextStatementFormatter();

    @Test
    void testCustomer() {
        Customer c = new CustomerBuilder().build();
        assertNotNull(c);
    }

    @Test
    void testGetName() {
        Customer c = new Customer("Sean");
        assertEquals("Sean", c.getName());
    }

    @Test
    void statementForCar() {
        Vehicle vehicle1 = new Car("Peugeot 207");
        Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
        Customer customer2 = new CustomerBuilder()
                .withName("Aoife")
                .withRentals(rental1)
                .build();
        String expected = "Rental Record for Aoife\n" +
                "\tPeugeot 207\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        String statement = customer2.generateStatement(statementFormatter);
        assertEquals(expected, statement);
    }

    @Test
    void statementForAllTerrainVehicle() {
        Vehicle vehicle1 = new AllTerrainVehicle("Landrover Freelander");
        Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
        Customer customer2 = new CustomerBuilder()
                .withName("Aoife")
                .withRentals(rental1)
                .build();
        String expected = "Rental Record for Aoife\n" +
                "\tLandrover Freelander\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        String statement = customer2.generateStatement(statementFormatter);
        assertEquals(expected, statement);
    }

    @Test
    void statementForMotorbike() {
        Vehicle vehicle1 = new Motorbike("Honda 50");
        Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
        Customer customer2 = new CustomerBuilder()
                .withName("Aoife")
                .withRentals(rental1)
                .build();
        String expected = "Rental Record for Aoife\n" +
                "\tHonda 50\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        String statement = customer2.generateStatement(statementFormatter);
        assertEquals(expected, statement);
    }

    @Test
    void statementForManyRentals() {
        Vehicle vehicle1 = new Motorbike("Honda 50");
        Rental rental1 = new Rental(vehicle1, 6); // 6 day rental
        Vehicle vehicle2 = new AllTerrainVehicle("Landrover Freelander");
        Rental rental2 = new Rental(vehicle2, 2); // 2 day rental
        Vehicle vehicle3 = new Car("Peugeot 207");
        Rental rental3 = new Rental(vehicle3, 8); // 8 day rental
        Customer customer1 = new CustomerBuilder()
                .withName("Sean")
                .withRentals(rental1, rental2, rental3)
                .build();
        String expected = "Rental Record for Sean\n" +
                "\tHonda 50\t6.0\n" +
                "\tLandrover Freelander\t6.0\n" +
                "\tPeugeot 207\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";
        String statement = customer1.generateStatement(statementFormatter);
        assertEquals(expected, statement);
    }

    //TODO make test for price breaks.
}

class CustomerBuilder {
    private String name = "default";
    private List<Rental> rentals = new ArrayList<>();

    public Customer build() {
        Customer result = new Customer(name);
        for (Rental rental : rentals) {
            result.addRental(rental);
        }
        return result;
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withRentals(Rental... rentals) {
        Collections.addAll(this.rentals, rentals);
        return this;
    }

}
