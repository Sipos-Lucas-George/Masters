public class SimpleCalculable implements Calculable {
    private int value;

    public SimpleCalculable(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void negate() {
        value *= -1;
    }
}
