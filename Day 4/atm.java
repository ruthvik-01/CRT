import java.util.Scanner;

abstract class ATM {
    abstract void checkBalance();

    abstract void withdraw(int amount);

    abstract void deposit(int amount);
}

class SBI extends ATM {
    private int balance;

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit successful");
    }
}

public class atm {
    public static void main(String[] args) {
        SBI sbi = new SBI();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sbi.checkBalance();
                    break;
                case 2:
                    sbi.withdraw(1000);
                    break;
                case 3:
                    sbi.deposit(1000);
                    break;
                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}