import java.util.ArrayList;

@FunctionalInterface
public interface Stringifier {
    ArrayList<String> stringify(Object[] o) throws StringifyException;
}
