import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class CashRegisterTest {
    private CashRegister cashRegister;

    @Before
    public void setUp() throws Exception {
        cashRegister = new CashRegister(0.5);
    }

    @Test
    public void testExceptions() {
        List<Consumer<CashRegister>> testFunctions = List.of(
                cr -> cr.setMoney(-1.0),
                cr -> cr.add(-1.0),
                cr -> cr.remove(-1.0),
                cr -> cr.remove(10.0)
        );

        for (Consumer<CashRegister> testFunction : testFunctions) {
            try {
                testFunction.accept(cashRegister);
                fail();
            } catch (IllegalArgumentException _) {}
        }
    }
}