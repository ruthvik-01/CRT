class parent {
    public void show() {
        System.out.println("parent hi");
    }
}

class child extends parent {
    public void show() {
        System.out.println("child hi");
    }
}

public class methodov {
    public static void main(String[] args) {
        child c = new child();
        c.show();

    }
}