import java.util.ArrayList;

public class CashRegister {
    private double money;
    private ArrayList<String> transactions;

    public CashRegister(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
        this.transactions = new ArrayList<>();
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void add(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money += money;
        transactions.add(money + " was added. Total now " + this.money);
    }

    public void remove(double money) {
        if (money < 0 || money > this.money) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money -= money;
        transactions.add(money + " was removed. Total now " + this.money);
    }

    public void printNTransactions(int numberOfTransactions) {
        int size = transactions.size();
        int noTransactions = Math.min(size, numberOfTransactions);
        for (int i = 0; i < noTransactions; ++i) {
            System.out.println(transactions.get(size - 1 - i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashRegister that = (CashRegister) o;
        return Double.compare(money, that.money) == 0;
    }

    @Override
    public String toString() {
        return "CashRegister [money=" + money + "]";
    }

    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister(0.5);
        CashRegister cashRegisterCopy = new CashRegister(0.5);
        System.out.println(cashRegister.equals(cashRegisterCopy));
        System.out.printf("%f %s\n", cashRegister.getMoney(), cashRegister);
        cashRegister.add(10);
        cashRegister.remove(10);
        cashRegister.add(100);
        cashRegister.remove(50);
        cashRegister.printNTransactions(100);
        cashRegister.printNTransactions(1);
    }
}
