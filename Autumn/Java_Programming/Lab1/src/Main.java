import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        var x = JOptionPane.showInputDialog(null, "Enter your name: ", "-_-", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Hi " + x, "Greetings", JOptionPane.ERROR_MESSAGE);
//        System.out.print("You've written -> ");
//        System.out.println(x);

        int n = 5;
        for (int i = 0; i < n; i++) {
            System.out.printf("Sqrt of pi = %f\n", Math.sqrt(Math.PI));
        }


    }
}