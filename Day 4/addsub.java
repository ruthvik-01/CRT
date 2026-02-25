interface venu {
    void add(int a, int b);
}

class vamshi implements venu {
    public void add(int a, int b) {
        System.out.println(a + b);
    }

    void sub(int a, int b) {
        System.out.println(a - b);
    }
}

public class addsub {
    public static void main(String[] args) {
        vamshi v = new vamshi();
        v.add(10, 20);
        v.sub(10, 20);
    }
}