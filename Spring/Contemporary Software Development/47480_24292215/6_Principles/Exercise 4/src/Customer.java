
class Customer {
  public Customer(Wallet wallet) {
    myWallet = wallet;
  }
  
  public float getWalletValue() {
    return myWallet.getValue();
  }

  public boolean charge(float amount) {
    if (myWallet.getValue() >= amount) {
      myWallet.subtractMoney(amount);
      return true;
    }
    return false;
  }
  
  private Wallet myWallet;
}
