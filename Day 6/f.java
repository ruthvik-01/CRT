import java.util.ArrayList;

public class f {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("ruthvik");
        s.add("ravi");
        s.add("ravi");
        System.out.println(s);
        System.out.println(s.get(1));
        System.out.println("size of arraylist is " + s.size());
        s.remove(1);
        System.out.println("After removing element at index 1: " + s);
        System.out.println("New size of arraylist is " + s.size());
        System.out.println("Contains 'ravi': " + s.contains("ravi"));
         s.set(0, "newElement");
        System.out.println("After setting element at index 1: " + s);
        s.clear();
        System.out.println("After clearing the arraylist: " + s);
       
    }
}
