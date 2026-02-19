public class bitwise {
    static int xor(int a, int b) {
        return a ^ b;

    }

    static int and(int a, int b) {
        return a & b;
    }

    static int or(int a, int b) {
        return a | b;

    }

    static int not(int a) {
        return ~a;
    }

    static int leftshift(int a, int b) {
        return a << b;
    }

    static int rightshift(int a, int b) {
        return a >> b;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        System.out.println(xor(a, b));
        System.out.println(and(a, b));
        System.out.println(or(a, b));
        System.out.println(not(a));
        System.out.println(leftshift(a, b));
        System.out.println(rightshift(a, b));
    }
}