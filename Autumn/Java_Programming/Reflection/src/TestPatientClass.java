import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import model.Patient;
import org.junit.jupiter.api.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPatientClass {
    Solution solution = new Solution();
    ArrayList<Object> result = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        result.clear();
    }

    @Test
    @Order(1)
    public void testExercise1() {
        result = solution.exercise1();
        assertEquals(result.size(), 2);
        Class<Patient> r1 = null;
        String r2 = "";
        try {
            r1 = (Class<Patient>) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Class<Patient>");
        }
        try {
            r2 = (String) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type String");
        }
        assertEquals(r1.getName(), r2);
    }

    @Test
    @Order(2)
    public void testExercise2() {
        result = solution.exercise2();
        assertEquals(result.size(), 2);
        Package r1 = null;
        String r2 = "";
        try {
            r1 = (Package) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Package");
        }
        try {
            r2 = (String) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type String");
        }
        assertEquals(r1.getName(), r2);
    }

    @Test
    @Order(3)
    public void testExercise3() {
        result = solution.exercise3();
        assertEquals(result.size(), 2);
        Constructor<Patient> r1 = null;
        Patient r2 = null;
        try {
            r1 = (Constructor<Patient>) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Constructor<Patient>");
        }
        try {
            r2 = (Patient) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type Patient");
        }
        assertEquals(r1.getName(), r2.getClass().getName());
        assertEquals(r1.getParameterCount(), 0);
        assertEquals(r2.toString(), ",0,0.0,");
    }

    @Test
    @Order(4)
    public void testExercise4() {
        result = solution.exercise4();
        assertEquals(result.size(), 2);
        Constructor<Patient> r1 = null;
        Patient r2 = null;
        try {
            r1 = (Constructor<Patient>) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Constructor<Patient>");
        }
        try {
            r2 = (Patient) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type Patient");
        }
        assertEquals(r1.getName(), r2.getClass().getName());
        assertEquals(r1.getParameterCount(), 4);
        assertEquals(r2.toString(), "Vin,57,102.7,Diesel");
    }

    @Test
    @Order(5)
    public void testExercise5() {
        result = solution.exercise5();
        assertEquals(result.size(), 2);
        Field r1 = null;
        int r2 = -1;
        try {
            r1 = (Field) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Field");
        }
        try {
            r2 = (int) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type int");
        }
        assertEquals(r1.getName(), "age");
        assertTrue(r1.canAccess(new Patient()));
        assertEquals(r2, 57);
    }

    @Test
    @Order(6)
    public void testExercise6() {
        result = solution.exercise6();
        assertEquals(result.size(), 2);
        Field[] r1 = null;
        ArrayList<Field> r2 = null;
        try {
            r1 = (Field[]) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Field[]");
        }
        try {
            r2 = (ArrayList<Field>) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type ArrayList<Field>");
        }
        String[] fields = Stream.of(r1).map(Field::getName).sorted().toArray(String[]::new);
        String[] filteredFields = r2.stream().map(Field::getName).sorted().toArray(String[]::new);
        String[] actualFields = {"age", "firstName", "lastName", "weight"};

        assertEquals(r1.length, 4);
        assertArrayEquals(fields, actualFields);
        assertEquals(r2.size(), 2);
        assertArrayEquals(filteredFields, Arrays.stream(actualFields)
                .filter(s -> s.endsWith("Name")).toArray(String[]::new));
    }

    @Test
    @Order(7)
    public void testExercise7() {
        result = solution.exercise7();
        assertEquals(result.size(), 2);
        Method[] r1 = null;
        ArrayList<Method> r2 = null;
        try {
            r1 = (Method[]) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Method[]");
        }
        try {
            r2 = (ArrayList<Method>) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type ArrayList<Method>");
        }
        String[] methods = Stream.of(r1).map(Method::getName).sorted().toArray(String[]::new);
        String[] filteredMethods = r2.stream().map(Method::getName).sorted().toArray(String[]::new);
        String[] actualMethods = {"convertWeightToPounds", "getLastName", "printPatient", "printPatient", "setWeight", "toString"};

        assertEquals(r1.length, 6);
        assertArrayEquals(methods, actualMethods);
        assertEquals(r2.size(), 2);
        assertArrayEquals(filteredMethods, Arrays.stream(actualMethods)
                .filter(s -> s.startsWith("get") || s.startsWith("set")).toArray(String[]::new));
    }

//    ------------------ BONUS PROBLEMS TESTS ------------------

    @Test
    @Order(8)
    public void testExercise8() {
        result = solution.exercise8();
        assertEquals(result.size(), 3);
        Field r1 = null;
        Field r2 = null;
        Patient r3 = null;
        try {
            r1 = (Field) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Field");
        }
        try {
            r2 = (Field) result.get(1);
        } catch (Exception _) {
            fail("Second result should be of type Field");
        }
        try {
            r3 = (Patient) result.getLast();
        } catch (Exception _) {
            fail("Third result should be of type Patient");
        }
        assertTrue(r1.canAccess(new Patient()));
        assertTrue(r2.canAccess(new Patient()));
        assertEquals(r1.getName(), "firstName");
        assertEquals(r2.getName(), "lastName");
        try {
            assertEquals(r1.get(r3), "Mark");
            assertEquals(r2.get(r3), "Sinclair");
        } catch (Exception _) {
            fail("Third result should be modified patient");
        }
        assertEquals(r3.toString(), "Mark,57,102.7,Sinclair");
    }

    @Test
    @Order(9)
    public void testExercise9() {
        result = solution.exercise9();
        assertEquals(result.size(), 2);
        Method r1 = null;
        double r2 = -1;
        try {
            r1 = (Method) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Method");
        }
        try {
            r2 = (double) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type double");
        }
        assertEquals(r1.getName(), "convertWeightToPounds");
        assertTrue(r1.canAccess(new Patient()));
        assertEquals(r1.getParameterCount(), 0);
        assertEquals(r1.getReturnType(), double.class);
        assertEquals(r2, 225.94);
    }

    @Test
    @Order(10)
    public void testExercise10() {
        result = solution.exercise10();
        assertEquals(result.size(), 2);
        Method r1 = null;
        String r2 = "";
        try {
            r1 = (Method) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Method");
        }
        try {
            r2 = (String) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type String");
        }
        assertEquals(r1.getName(), "printPatient");
        assertTrue(r1.canAccess(null));
        assertEquals(r1.getParameterCount(), 1);
        assertEquals(r1.getReturnType(), String.class);
        assertEquals(r2, "Mark Sinclair 57 yo 102.7kg");
    }

    @Test
    @Order(11)
    public void testExercise11() {
        result = solution.exercise11();
        assertEquals(result.size(), 4);
        Annotation[] r1 = null;
        String r2 = "";
        Description r3 = null;
        String r4 = "";
        try {
            r1 = (Annotation[]) result.getFirst();
        } catch (Exception _) {
            fail("First result should be of type Annotation[]");
        }
        try {
            r2 = (String) result.get(1);
        } catch (Exception _) {
            fail("Second result should be of type String");
        }
        try {
            r3 = (Description) result.get(2);
        } catch (Exception _) {
            fail("First result should be of type Description");
        }
        try {
            r4 = (String) result.getLast();
        } catch (Exception _) {
            fail("Second result should be of type String");
        }
        assertEquals(r1.length, 1);
        assertEquals(r1[0].annotationType(), Description.class);
        assertEquals(r1[0].toString(), "@jdk.jfr.Description(\"Weight specified in kg\")");
        assertEquals(r2, "Description");
        assertEquals(r3.toString(), "@jdk.jfr.Description(\"Weight specified in kg\")");
        assertEquals(r3.value(), r4);
    }
}
