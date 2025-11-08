import java.util.ArrayList;

public class Main {
    private Stringifier concatenate, translator, sumUp, reverser;

    public Main() {
        /*
         * complete the constructor to initialise
         * the 4 Stringifier instance variables
         * you may introduce additional classes
         * and methods if you wish.
         *
         * Unit tests will only call the constructor
         * and the 4 accessor methods, however.
         */
        concatenate = (Object[] o) -> {
            if (o.length == 0) throw new StringifyException();
            ArrayList<String> result = new ArrayList<>();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < o.length - 1; i++) {
                s.append(o[i]).append(" ");
            }
            s.append(o[o.length - 1].toString()).append(".");
            result.add(s.toString());
            return result;
        };

        translator = (Object[] o) -> {
            if (o.length == 0) throw new StringifyException();
            ArrayList<String> result = new ArrayList<>();
            for (Object object : o) {
                StringBuilder s = new StringBuilder();
                String string = object.toString();
                for (int i = 0; i < string.length(); i++) {
                    switch (string.charAt(i)) {
                        case '0' -> s.append("zero");
                        case '1' -> s.append("one");
                        case '2' -> s.append("two");
                        case '3' -> s.append("three");
                        case '4' -> s.append("four");
                        case '5' -> s.append("five");
                        case '6' -> s.append("six");
                        case '7' -> s.append("seven");
                        case '8' -> s.append("eight");
                        case '9' -> s.append("nine");
                        case '+' -> s.append("plus");
                        case '-' -> s.append("minus");
                        case 'x' -> s.append("times");
                        case '/' -> s.append("divided by");
                        case '=' -> s.append("equals");
                        case ' ' -> {
                            continue;
                        }
                        default -> throw new StringifyException();
                    }
                    if (i != string.length() - 1) {
                        s.append(" ");
                    }
                }
                result.add(s.toString());
            }
            return result;
        };

        sumUp = (Object[] o) -> {
            if (o.length == 0) throw new StringifyException();
            ArrayList<String> result = new ArrayList<>();
            int inst = (o[0] instanceof String) ? 1 : 0;
            StringBuilder s = new StringBuilder();
            double sum = 0;
            for (Object object : o) {
                if ((inst == 0 && object instanceof String) || (inst == 1 && !(object instanceof String))) {
                    throw new StringifyException();
                }
                if (inst == 1) {
                    s.append(object).append(" ");
                } else {
                    sum += (object instanceof Integer) ? ((Integer) object).doubleValue() : ((Double) object);
                }
            }
            result.add((inst == 0) ? Double.toString(sum) : s.replace(s.toString().length() - 1, s.toString().length(), ".").toString());
            return result;
        };

        reverser = (Object[] o) -> {
            if (o.length == 0) throw new StringifyException();
            ArrayList<String> result = new ArrayList<>();
            StringBuilder s = new StringBuilder();
            for (Object object : o) {
                s.append(object.toString());
            }
            result.add((s.toString().contentEquals(s.reverse())) ? "true" : "false");
            return result;
        };
    }

    public Stringifier getConcatenate() {
        return concatenate;
    }

    public Stringifier getTranslator() {
        return translator;
    }

    public Stringifier getSumUp() {
        return sumUp;
    }

    public Stringifier getReverser() {
        return reverser;
    }
}
