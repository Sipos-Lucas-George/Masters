public class MemberData {
    public static void main(String[] args) {
        String firstName = "Lucas";
        char middleInitial = 'G';
        String lastName = "Sps";
        int membershipNumber = 123456789;
        final double membershipFee = 9.99;
        boolean membershipOwing = true;
        enum membershipStatus { active, past, hold };
        System.out.printf("Full name: %s %c. %s%n", firstName, middleInitial, lastName);
        System.out.printf("Membership number: %d%n", membershipNumber);
        System.out.printf("Membership fee: %.2f%n", membershipFee);
        System.out.printf("Membership owing %s and status %s%n", membershipOwing ? membershipFee : "0", membershipStatus.active);
    }
}
