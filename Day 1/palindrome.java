public class palindrome {
    static boolean palindrome1(int n) {
        int rev = 0;
        int temp = n;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev == temp;
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println(palindrome1(n));
    }
}
