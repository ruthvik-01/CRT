package MiniProject;

import java.util.Scanner;

public class canteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("|           Menu           |");
            System.out.println("----------------------------");
            System.out.println("| " + "1.Tiffin" + "                 |");
            System.out.println("| " + "2.Lunch" + "                  |");
            System.out.println("| " + "3.Dinner" + "                 |");
            System.out.println("| " + "4.Snacks" + "                 |");
            System.out.println("| " + "5.Beverages" + "              |");
            System.out.println("| " + "6.Exit" + "                   |");
            System.out.println("----------------------------");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    tiffin();
                    break;
                case 2:
                    lunches();
                    break;
                case 3:
                    dinner();
                    break;
                case 4:
                    snacks();
                    break;
                case 5:
                    beverages();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void lunches() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("|         Lunch            |");
            System.out.println("----------------------------");
            System.out.println("| Enter your choice :      |");
            System.out.println("| 1. Veg Lunch             |");
            System.out.println("| 2. Non-Veg Lunch         |");
            System.out.println("| 3. Exit                  |");
            System.out.println("----------------------------");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    VegLunch();
                    break;
                case 2:
                    NonVegLunch();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void NonVegLunch() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("|       Non-Veg Lunch             |");
            System.out.println("---------------------------------");
            System.out.println("| Enter your choice :             |");
            System.out.println("| 1. Chicken Biryani : Cost 100  |");
            System.out.println("| 2. Mutton Biryani  : Cost 50   |");
            System.out.println("| 3. Fish Biryani    : Cost 150  |");
            System.out.println("| 4. Exit                         |");
            System.out.println("---------------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 2:
                    System.out.println("Product cost : 50\n" + "With tax : 55");
                    break;
                case 3:
                    System.out.println("Product cost : 150\n" + "With tax : 162");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

    public static void tiffin() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("|           Tiffin           |");
            System.out.println("----------------------------");
            System.out.println("| Enter your choice :        |");
            System.out.println("| 1. Vada : Cost 10         |");
            System.out.println("| 2. Dosa : Cost 20         |");
            System.out.println("| 3. Idli : Cost 30         |");
            System.out.println("| 4. Puri : Cost 40         |");
            System.out.println("| 5. Exit                    |");
            System.out.println("----------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:
                    System.out.println("Product cost : 20\n" + "With tax : 22");
                    break;
                case 3:
                    System.out.println("Product cost : 30\n" + "With tax : 32");
                    break;
                case 4:
                    System.out.println("Product cost : 40\n" + "With tax : 42");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

    public static void VegLunch() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("|         Veg Lunch          |");
            System.out.println("----------------------------");
            System.out.println("| Enter your choice :        |");
            System.out.println("| 1. Veg Biryani : Cost 100 |");
            System.out.println("| 2. Dal         : Cost 50  |");
            System.out.println("| 3. Panner      : Cost 150 |");
            System.out.println("| 4. Curd        : Cost 100 |");
            System.out.println("| 5. Exit                    |");
            System.out.println("----------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 2:
                    System.out.println("Product cost : 50\n" + "With tax : 55");
                    break;
                case 3:
                    System.out.println("Product cost : 150\n" + "With tax : 162");
                    break;
                case 4:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

    public static void dinner() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("|           Dinner           |");
            System.out.println("----------------------------");
            System.out.println("| Enter your choice :        |");
            System.out.println("| 1. Veg Biryani : Cost 100 |");
            System.out.println("| 2. Dal         : Cost 50  |");
            System.out.println("| 3. Chicken Biryani : Cost 150 |");
            System.out.println("| 4. Curd        : Cost 100 |");
            System.out.println("| 5. Exit                  |");
            System.out.println("----------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 2:
                    System.out.println("Product cost : 50\n" + "With tax : 55");
                    break;
                case 3:
                    System.out.println("Product cost : 150\n" + "With tax : 162");
                    break;
                case 4:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

    public static void snacks() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("|          Snacks            |");
            System.out.println("----------------------------");
            System.out.println("| Enter your choice :      |");
            System.out.println("| 1. Chips       : Cost 100 |");
            System.out.println("| 2. Chocolates  : Cost 50  |");
            System.out.println("| 3. Biscuits    : Cost 150 |");
            System.out.println("| 4. Cookies     : Cost 100 |");
            System.out.println("| 5. Exit                  |");
            System.out.println("----------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 2:
                    System.out.println("Product cost : 50\n" + "With tax : 55");
                    break;
                case 3:
                    System.out.println("Product cost : 150\n" + "With tax : 162");
                    break;
                case 4:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

    public static void beverages() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("|        Beverages           |");
            System.out.println("----------------------------");
            System.out.println("| Enter your choice :      |");
            System.out.println("| 1. Coke      : Cost 100 |");
            System.out.println("| 2. Fanta     : Cost 50  |");
            System.out.println("| 3. Pepsi     : Cost 150 |");
            System.out.println("| 4. Sprite    : Cost 100 |");
            System.out.println("| 5. Exit                  |");
            System.out.println("----------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 2:
                    System.out.println("Product cost : 50\n" + "With tax : 55");
                    break;
                case 3:
                    System.out.println("Product cost : 150\n" + "With tax : 162");
                    break;
                case 4:
                    System.out.println("Product cost : 100\n" + "With tax : 112");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }
}
