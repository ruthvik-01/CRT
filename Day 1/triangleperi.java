public class triangleperi {
    static void peri(int a, int b, int c) {
        int perimeter = a + b + c;
        System.out.println("Perimeter = " + perimeter);
    }

    static void Area(int a, int b) {
        System.out.println("Area = " + 0.5 * a * b);
    }

    public static void main(String[] args) {
        peri(5, 7, 10);
        Area(10, 15);
    }
}
