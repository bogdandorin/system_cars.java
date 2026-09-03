import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Car", "Toyota", 80, 4));
        vehicles.add(new Car("Car", "Ford", 75, 2));
        vehicles.add(new Bike("Bike", "Yamaha", 100, 649));
        vehicles.add(new Bike("Bike", "Honda", 110, 0));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.describe());
        }

        Collections.sort(vehicles);

        System.out.println("\nSorted by speed:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.describe());
        }

        vehicles.sort(Comparator.comparing(v -> v.getModel()));
        System.out.println("\nVehicles are in alphabetical order:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.describe());
        }

    }
}

class Vehicle implements Comparable<Vehicle> {
    private String type;
    private String model;
    private int speed;

    public Vehicle(String type, String model, int speed) {
        this.type = type;
        this.model = model;
        this.speed = speed;
    }

    public void accelerate(int amount) {
        speed += amount;
    }

    public String describe() {
        return type + " " + model + " drives with " + speed + " km/h";
    }

    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.speed, other.speed);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }
    
}

class Car extends Vehicle {
    int numberOfDoors;

    public Car(String type, String model, int speed, int numberOfDoors) {
        super(type, model, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String describe() {
        return super.describe() + " with " + numberOfDoors + " doors";
    }
}

class Bike extends Vehicle {
        
    int cubicCapacity;

    public Bike(String type, String model, int speed, int cubicCapacity) {
        super(type, model, speed);
        this.cubicCapacity = cubicCapacity;
    }

    @Override
    public String describe() {
        return super.describe() + (cubicCapacity > 0 ? " and has a cubic capacity of " + cubicCapacity : " and does not have a cubic capacity");
    }
}

