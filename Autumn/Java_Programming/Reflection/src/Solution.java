import jdk.jfr.Description;
import model.Patient;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Solution {
    Class<?> classPatient;
    Object defaultPatient;
    Object newPatient;

    public ArrayList<Object> exercise1() {
//        initialise classPatient with class Patient;
//        return classPatient, className as String
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise2() {
//        get package name;
//        return Package, packageName as String
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise3() {
//        construct the defaultPatient;
//        return Constructor, defaultPatient
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise4() {
//        construct newPatient with "Vin", 57, 102.7, "Diesel";
//        return Constructor, newPatient
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise5() {
//        get field "age" by name from newPatient;
//        return Field, value as int
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise6() {
//        get all String fields;
//        return Field[] (all), ArrayList<Field> (only Strings)
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise7() {
//        get all the getters and setters methods;
//        return Method[] (all methods), ArrayList<Method> (getters and setters)
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

//    ------------------ BONUS PROBLEMS ------------------

    public ArrayList<Object> exercise8() {
//        modify firstName and lastName to "Mark" "Sinclair" from newPatient;
//        return Field (firstName), Field (lastName), newPatient
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise9() {
//        get the convertWeightToPounds function and return the returned value;
//        return Method, value as double
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise10() {
//        get the printPatient(Patient patient) static function and return the returned value;
//        return Method, value as String
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Object> exercise11() {
//        get the Annotation and Description of Field weight
//        return Annotation[], annotationName as String, Description, descriptionValue as String
        ArrayList<Object> result = new ArrayList<>();

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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
