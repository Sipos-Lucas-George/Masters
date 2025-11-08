package inter;

import java.util.Scanner;

public class StringCalculable implements Calculable {
    private int value;

    public StringCalculable(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            this.value = convertValue(value);
        }
    }

    private int convertValue(String value) {
        Scanner s = new Scanner(value);
        String str;
        StringBuilder newValue = new StringBuilder();

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Value cannot be empty");
        }

        while (s.hasNext()) {
            str = s.next();
            switch (str) {
                case "zero": newValue.append(0); break;
                case "one": newValue.append(1); break;
                case "two": newValue.append(2); break;
                case "three": newValue.append(3); break;
                case "four": newValue.append(4); break;
                case "five": newValue.append(5); break;
                case "six": newValue.append(6); break;
                case "seven": newValue.append(7); break;
                case "eight": newValue.append(8); break;
                case "nine": newValue.append(9); break;
                default: throw new IllegalArgumentException("Unknown word: " + str);
            }
        }

        return Integer.parseInt(newValue.toString());
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
