public class AddingCalculator implements Calculator {

    @Override
    public Calculable calculate(Calculable[] calculables) {
        if (calculables.length == 0) {
            throw new IllegalArgumentException("There is no calculable to add");
        }
        
        int sum = 0;
        for (Calculable calculable : calculables) {
            sum += calculable.getValue();
        }
        return new SimpleCalculable(sum);
    }
}
