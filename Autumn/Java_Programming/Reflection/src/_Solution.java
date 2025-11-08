import jdk.jfr.Description;
import model.Patient;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class _Solution {
    Class<?> classPatient;
    Object defaultPatient;
    Object newPatient;

    public ArrayList<Object> exercise1() {
//        initialise classPatient with class Patient;
//        return classPatient, className as String
        ArrayList<Object> result = new ArrayList<>();
        try {
            classPatient = Class.forName("model.Patient");
        } catch (ClassNotFoundException _) {
        }
        result.add(classPatient);
        result.add(classPatient.getName());
        return result;
    }

    public ArrayList<Object> exercise2() {
//        get package name;
//        return Package, packageName as String
        ArrayList<Object> result = new ArrayList<>();
        Package pack = classPatient.getPackage();
        result.add(pack);
        result.add(pack.getName());
        return result;
    }

    public ArrayList<Object> exercise3() {
//        construct the defaultPatient;
//        return Constructor, defaultPatient
        ArrayList<Object> result = new ArrayList<>();
        Constructor<?> constructor;
        try {
            constructor = classPatient.getConstructor();
        } catch (NoSuchMethodException _) {
            return result;
        }
        try {
            defaultPatient = constructor.newInstance();
        } catch (Exception _) {
            return result;
        }
        result.add(constructor);
        result.add(defaultPatient);
        return result;
    }

    public ArrayList<Object> exercise4() {
//        construct newPatient with "Vin", 57, 102.7, "Diesel";
//        return Constructor, newPatient
        ArrayList<Object> result = new ArrayList<>();
        Constructor<?> constructor;
        try {
            constructor = classPatient.getConstructor(String.class, int.class, double.class, String.class);
        } catch (NoSuchMethodException _) {
            return result;
        }
        try {
            newPatient = constructor.newInstance("Vin", 57, 102.7, "Diesel");
        } catch (Exception _) {
            return result;
        }
        result.add(constructor);
        result.add(newPatient);
        return result;
    }

    public ArrayList<Object> exercise5() {
//        get field "age" by name from newPatient;
//        return Field, value as int
        ArrayList<Object> result = new ArrayList<>();
        Field field;
        try {
            field = classPatient.getDeclaredField("age");
        } catch (NoSuchFieldException _) {
            return result;
        }
        field.setAccessible(true);
        result.add(field);
        try {
            result.add((int) field.get(newPatient));
        } catch (IllegalAccessException _) {
        }
        return result;
    }

    public ArrayList<Object> exercise6() {
//        get all String fields;
//        return Field[] (all), ArrayList<Field> (only Strings)
        ArrayList<Object> result = new ArrayList<>();
        Field[] allFields = classPatient.getDeclaredFields();
        ArrayList<Field> filteredFields = new ArrayList<>();
        for (Field f : allFields) {
            if (f.getType().equals(String.class)) {
                filteredFields.add(f);
            }
        }
        result.add(allFields);
        result.add(filteredFields);
        return result;
    }

    public ArrayList<Object> exercise7() {
//        get all the getters and setters methods;
//        return Method[] (all methods), ArrayList<Method> (getters and setters)
        ArrayList<Object> result = new ArrayList<>();
        Method[] allMethods = classPatient.getDeclaredMethods();
        ArrayList<Method> filteredMethods = new ArrayList<>();
        for (Method m : allMethods) {
            if (m.getName().startsWith("set") || m.getName().startsWith("get")) {
                filteredMethods.add(m);
            }
        }
        result.add(allMethods);
        result.add(filteredMethods);
        return result;
    }

//    ------------------ BONUS PROBLEMS ------------------

    public ArrayList<Object> exercise8() {
//        modify firstName and lastName to "Mark" "Sinclair" from newPatient;
//        return Field (firstName), Field (lastName), newPatient
        ArrayList<Object> result = new ArrayList<>();
        Field firstNameField, lastNameField;
        try {
            firstNameField = classPatient.getDeclaredField("firstName");
            lastNameField = classPatient.getDeclaredField("lastName");
        } catch (NoSuchFieldException _) {
            return result;
        }
        firstNameField.setAccessible(true);
        lastNameField.setAccessible(true);
        try {
            firstNameField.set(newPatient, "Mark");
            lastNameField.set(newPatient, "Sinclair");
        } catch (IllegalAccessException _) {
            return result;
        }
        result.add(firstNameField);
        result.add(lastNameField);
        result.add(newPatient);
        return result;
    }

    public ArrayList<Object> exercise9() {
//        get the convertWeightToPounds function and return the returned value;
//        return Method, value as double
        ArrayList<Object> result = new ArrayList<>();
        Method method;
        double value;
        try {
            method = classPatient.getDeclaredMethod("convertWeightToPounds");
        } catch (NoSuchMethodException _) {
            return result;
        }
        method.setAccessible(true);
        try {
            value = (double) method.invoke(newPatient);
        } catch (Exception _) {
            return result;
        }
        result.add(method);
        result.add(value);
        return result;
    }

    public ArrayList<Object> exercise10() {
//        get the printPatient(Patient patient) static function and return the returned value;
//        return Method, value as String
        ArrayList<Object> result = new ArrayList<>();
        Method method;
        String value;
        try {
            method = classPatient.getDeclaredMethod("printPatient", Patient.class);
        } catch (NoSuchMethodException _) {
            return result;
        }
        method.setAccessible(true);
        try {
            value = (String) method.invoke(null, (Patient) newPatient);
        } catch (Exception _) {
            return result;
        }
        result.add(method);
        result.add(value);
        return result;
    }

    public ArrayList<Object> exercise11() {
//        get the Annotation and Description of Field weight
//        return Annotation[], annotationName as String, Description, descriptionValue as String
        ArrayList<Object> result = new ArrayList<>();
        Field field;
        try {
            field = classPatient.getDeclaredField("weight");
        } catch (NoSuchFieldException _) {
            return result;
        }
        Annotation[] annotations = field.getAnnotations();
        result.add(annotations);
        result.add(annotations[0].annotationType().getSimpleName());
        result.add((Description)annotations[0]);
        result.add(((Description)annotations[0]).value());
        return result;
    }

    public static void main(String[] args) {
        _Solution solution = new _Solution();
        System.out.println(solution.exercise1());
        System.out.println(solution.exercise2());
        System.out.println(solution.exercise3());
        System.out.println(solution.exercise4());
        System.out.println(solution.exercise5());
        System.out.println(solution.exercise6());
        System.out.println(solution.exercise7());
        System.out.println(solution.exercise8());
        System.out.println(solution.exercise9());
        System.out.println(solution.exercise10());
        System.out.println(solution.exercise11());
    }
}
