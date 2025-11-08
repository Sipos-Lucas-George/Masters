package inter;

public class ExampleLambda {

    public static void main(String[] args) {
        Calculator adder = (calculables) -> {
            if (calculables.length == 0) {
                throw new IllegalArgumentException("Array is empty");
            }

            int sum = 0;
            for (Calculable c: calculables) {
                sum += c.getValue();
            }

            return new SimpleCalculable(sum);
        };

        Calculator multiplier = (calculables) -> {
            if (calculables.length == 0) {
                throw new IllegalArgumentException("Array is empty");
            }

            int total = calculables[0].getValue();
            if (calculables.length > 1) {
                for (int i = 1; i < calculables.length; i++) {
                    total *= calculables[i].getValue();
                }
            }

            return new SimpleCalculable(total);
        };

        Calculable[] c = new Calculable[3];
        c[0] = new SimpleCalculable(2);
        c[1] = new SimpleCalculable(3);
        c[2] = new SimpleCalculable(4);

        Calculable cc = adder.calculate(c);
        System.out.println(cc.getValue());
        cc = multiplier.calculate(c);
        System.out.println(cc.getValue());
    }

}
