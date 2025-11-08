import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Q1: Dynamically load the Person class & print the name of the class
            Class<?> personClass = Class.forName("Person");
            System.out.println("Class Name: " + personClass.getName());

            // Q2: Retrieve all fields (including private ones)
            System.out.println("Fields:");
            Field[] fields = personClass.getDeclaredFields();

            for(Field field : fields) {
                System.out.println(field.getName());
            }

            // Q3: Retrieve all methods (including private ones)
            System.out.println("Methods:");
            Method[] methods = personClass.getDeclaredMethods();
            Arrays.stream(methods).forEach(method -> System.out.println(method.getName() + " -> " + method.toGenericString()));

            // Q4: Retrieve the constructor and create an object
            System.out.println("Constructors:");
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object person = constructor.newInstance("Lucas", 22);
            Person person1 = (Person) person;
            System.out.println(person1.getName());
            System.out.println(person1.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
