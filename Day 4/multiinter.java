interface hi {
    void hello();
}

abstract class bye1 {
    abstract void bye();
}

class he extends bye1 implements hi {
    public void hello() {
        System.out.println("Hello");
    }

    public void bye() {
        System.out.println("Bye");
    }
}

public class multiinter {
    public static void main(String[] args) {
        he h = new he();
        h.hello();
        h.bye();
    }
}