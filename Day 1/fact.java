public class fact {
    static int fact1(int n) {
        if (n == 0)
            return 1;
        return n * fact1(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact1(n));
    }
}
