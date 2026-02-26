
import java.util.LinkedList;

public class linI {
    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        s.add("ruthvik");
        s.add("ravi");
        s.remove(0  );
        s.set(1, "rav");
        s.removeFirst();
        System.out.println(s);
        LinkedList<Integer> i = new LinkedList<>();
        i.add(1);
        i.add(2);  
        i.remove(1  ); 
        System.out.println(i);
    }
}
