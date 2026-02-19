import java.util.Scanner;

public class rect_num {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
        for (int i = 1; i <= n - (n / 2); i++)

        {
            for (int j = 1; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();

    }
}
