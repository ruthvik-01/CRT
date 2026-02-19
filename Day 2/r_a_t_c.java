import java.util.Scanner;

//right angled triangle using char
public class r_a_t_c {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++)

        {
            char ch = 'A';

            for (int j = 1; j <= i; j++) {

                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
        sc.close();

    }
}
