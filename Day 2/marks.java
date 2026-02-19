import java.util.Scanner;

public class marks {
    static void checkMarks(int a) {
        if ((a > 35) && (a < 50)) {
            System.out.println("just pass can do better: " + a);

        } else if ((a >= 50) && (a < 75)) {
            System.out.println("Second: " + a);
        } else if (a >= 75) {
            System.out.println("First: " + a);

        } else {
            System.out.println("Fail: " + a);

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1;) {
            System.out.println("Enter marks: ");
            int a = sc.nextInt();
            checkMarks(a);
        }

    }
}
