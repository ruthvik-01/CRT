interface interfaces {

    void rect(int h, int b);

    void sq(int s);

    void tri(int h, int b);
}

class Area implements interfaces {
    public void rect(int h, int b) {
        System.out.println("Area of rectangle: " + (h * b));
    }

    public void sq(int s) {
        System.out.println("Area of square: " + (s * s));
    }

    public void tri(int h, int b) {
        System.out.println("Area of triangle: " + (0.5 * h * b));
    }
}

public class inter {
    public static void main(String[] args) {
        Area a = new Area();
        a.rect(10, 20);
        a.sq(10);
        a.tri(10, 20);
    }
}