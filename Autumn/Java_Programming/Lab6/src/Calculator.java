@FunctionalInterface
public interface Calculator {
    public Calculable calculate(Calculable[] calculables);

    static Calculator generateCalculator(String type) {
        if (type.equalsIgnoreCase("adder")) {
            return new AddingCalculator();
        } else if (type.equalsIgnoreCase("multiplier")) {
            return new MultiplierCalculator();
        } else {
            throw new IllegalArgumentException("Unknown Calculator type: " + type);
        }
    }
}
