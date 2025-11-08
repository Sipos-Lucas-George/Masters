package inter;

public class MultiplierCalculator implements Calculator {
    @Override
    public Calculable calculate(Calculable[] calculables) {
        if (calculables.length == 0) {
            throw new IllegalArgumentException("The calculables array is empty");
        }
        
        int multiplier = 1;
        for (Calculable calculable : calculables) {
            multiplier *= calculable.getValue();
        }
        return new SimpleCalculable(multiplier);
    }

    public static void main(String[] args) {
        Calculable[] c = new Calculable[3];
        c[0] = new SimpleCalculable(2);
        c[1] = new SimpleCalculable(3);
        c[2] = new SimpleCalculable(4);
        MultiplierCalculator calculator = new MultiplierCalculator();
        System.out.println(calculator.calculate(c).getValue());

        Calculator a = Calculator.generateCalculator("aDdEr");
        System.out.println(a.calculate(c).getValue());

        MultiplierCalculator m = (MultiplierCalculator) Calculator.generateCalculator("multiplier");
        System.out.println(m.calculate(c).getValue());
    }
}
