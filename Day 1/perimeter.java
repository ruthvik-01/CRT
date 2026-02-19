public class perimeter {
    static int rect(int l, int b) {
        return 2 * (l + b);
    }

    static double circle(int r) {
        return 2 * 3.14 * r;
    }

    static int square(int s) {
        return 4 * s;
    }

    public static void main(String[] args) {
        int l = 10;
        int b = 20;
        int r = 30;
        int s = 40;
        System.out.println(rect(l, b));
        System.out.println(circle(r));
        System.out.println(square(s));
    }
}
