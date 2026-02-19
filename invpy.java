import java.util.Scanner;

public class invpy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");

            }
            for (int k = 5; k >= (2 * i - 1); k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
