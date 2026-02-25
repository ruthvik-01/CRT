import java.util.Scanner;

public class simpleI {
    public static double formula(float p, float r, float t) {
        double result = (p * r * t) / 100;
        return result;
    }

    public static void show(double result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        float p, r, t;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter p value");
        p = sc.nextFloat();
        System.out.println("enter r value");
        r = sc.nextFloat();
        System.out.println("enter t value");
        t = sc.nextFloat();
        double result = formula(p, r, t);
        show(result);

    }
}