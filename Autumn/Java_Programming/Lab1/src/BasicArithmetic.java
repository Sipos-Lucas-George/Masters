import java.util.Scanner;

public class BasicArithmetic {
    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static float divide(int a, int b) {
        return (float) a / b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int a = input.nextInt();
        System.out.print("Enter second integer: ");
        int b = input.nextInt();
        int c = add(a, b);
        System.out.println("Sum: " + c);
        System.out.println("Subtract: " + subtract(a, b));
        System.out.println("Multiply: " + multiply(a, b));
        System.out.println("Divide: " + divide(a, b));
    }
}
