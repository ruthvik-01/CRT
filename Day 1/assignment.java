public class assignment {

    static void plusequalsto(int a, int b) {
        System.out.println(a += b);
    }

    static void minusequalsto(int a, int b) {
        System.out.println(a -= b);
    }

    static void multiplyequalsto(int a, int b) {
        System.out.println(a *= b);
    }

    static void divideequalsto(int a, int b) {
        System.out.println(a /= b);
    }

    static void modulusqualsto(int a, int b) {
        System.out.println(a %= b);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 25;
        System.out.println(a = b);
        plusequalsto(a, b);
        minusequalsto(a, b);
        multiplyequalsto(a, b);
        divideequalsto(a, b);
        modulusqualsto(a, b);
    }
}
