public class area {
    static int rect(int l, int b) {
        return l * b;
    }

    static double circle(int r) {
        double a = 3.14;
        return a * r * r;
    }

    static int square(int s) {
        return s * s;
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
