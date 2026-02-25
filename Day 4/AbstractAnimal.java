
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();

    abstract void move();

    void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }

    void displayAnimal() {
        System.out.println("\n--- " + name + " ---");
        makeSound();
        move();
        sleep();
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }

    void move() {
        System.out.println(name + " runs on 4 legs");
    }
}

class Bird extends Animal {
    Bird(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " says: Tweet Tweet!");
    }

    void move() {
        System.out.println(name + " flies with wings");
    }
}

class Fish extends Animal {
    Fish(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " says: Blub Blub!");
    }

    void move() {
        System.out.println(name + " swims with fins");
    }
}

public class AbstractAnimal {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy");
        Bird b = new Bird("Tweety");
        Fish f = new Fish("Nemo");

        d.displayAnimal();
        b.displayAnimal();
        f.displayAnimal();
    }
}
