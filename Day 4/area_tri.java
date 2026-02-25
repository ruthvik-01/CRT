import java.util.Scanner;

public class area_tri {

    public static double input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter b value");
        float b = sc.nextFloat();
        System.out.println("enter h value");
        float h = sc.nextFloat();
        double result = 0.5 * b * h;
        return result;
    }

    public static void show(double result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        double result = input();

        show(result);

    }
}