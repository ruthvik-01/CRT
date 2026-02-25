import java.util.*;

class bank {
    private double balance;

    public void withdraw(int amount) {
        if (balance > 0 && amount <= balance)

        {
            balance -= amount;
            System.out.println("your balance:" + balance);
        } else {
            System.out.println("inavalid balance");
        }

    }

    public void deposit(int amount) {
        if (amount > 0) {

            balance += amount;
            System.out.println("your balance" + balance);

        } else {
            System.out.println("invalid");
        }
    }

    public void getbalance() {
        System.out.println(balance);
    }

}

public class user {
    public static void main(String[] args) {
        bank b = new bank();
        b.deposit(1000);
        b.deposit(1000000);
        b.withdraw(500);
        b.getbalance();

    }
}
