interface hi {
    void hello();
}

class he implements hi {
    public void hello() {
        System.out.println("Hello");
    }
}

public class main {
    public static void main(String[] args) {
        he h = new he();
        h.hello();
    }
}