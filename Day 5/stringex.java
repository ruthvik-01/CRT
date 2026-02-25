public class stringex {
    public static void main(String[] args) {
        String s1 = "hello";

        try {
            System.out.println(s1.charAt(10));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}