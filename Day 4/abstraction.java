abstract class Vehicle {
    abstract void start(); // abstract method
}

class Car extends Vehicle {
    public void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {
    public void start() {
        System.out.println("Bike starts with kick");
    }
}

public class abstraction {
    public static void main(String[] args) {
        Car v1 = new Car(); // or Vehicle v1 = new Car();
        Bike v2 = new Bike(); // or Vehicle v2 = new Bike();

        v1.start();
        v2.start();
    }
}
// vehicle -->car,bike
// car --> start
// bike --> start
// abstarction --> vehicle