import java.util.Scanner;

public class MemberEntry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine().trim().toUpperCase();
        System.out.print("Enter your middle name initial: ");
        char middleInitial = Character.toUpperCase(input.nextLine().trim().charAt(0));
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine().trim().toUpperCase();
        System.out.print("Enter your membership number: ");
        int membershipNumber = Integer.parseInt(input.nextLine().trim());
        System.out.print("Enter your fee: ");
        final double membershipFee = Double.parseDouble(input.nextLine().trim());
        boolean membershipOwing = true;
        enum membershipStatus { active, past, hold };
        System.out.printf("Full name: %s %c. %s%n", firstName, middleInitial, lastName);
        System.out.printf("Membership number: %d%n", membershipNumber);
        System.out.printf("Membership fee: %.2f%n", membershipFee);
        System.out.printf("Membership owing %s and status %s%n", membershipOwing ? membershipFee : "0", membershipStatus.active);
    }
}
