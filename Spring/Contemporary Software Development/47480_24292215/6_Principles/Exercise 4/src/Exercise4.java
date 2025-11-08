
public class Exercise4 {
  public static void main(String[] args) {
    ShopKeeper shopkeeper = new ShopKeeper();
    Wallet wallet = new Wallet(95);
    System.out.println("Initial value in wallet is: €" + wallet.getValue());
    Customer customer = new Customer(wallet);
    shopkeeper.chargeCustomer(customer, 50);
    System.out.println("Value in wallet after purchase is: €" + wallet.getValue());
  }
}
