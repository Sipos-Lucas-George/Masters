
class Wallet {
  public  Wallet(float value) {
    this.value = value;
  }
  
  public float getValue() {
    return value;
  }
  
  public void addMoney(float deposit) {
    value += deposit;
  }
  
  public void subtractMoney(float debit) {
    value -= debit;
  }
  
  private float value;
}
