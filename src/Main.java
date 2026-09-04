import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    // Group vehicles by type and return a HashMap where the key is the vehicle type and the value is a list of vehicles of that type
    public static HashMap<String, ArrayList<Vehicle>> groupByType(ArrayList<Vehicle> vehicles) {
        HashMap<String, ArrayList<Vehicle>> groupedVehicles = new HashMap<>();

       for (Vehicle vehicle : vehicles) {
            String type = vehicle.getType();
            if (!groupedVehicles.containsKey(type)) {
                groupedVehicles.put(type, new ArrayList<>());
            }
            groupedVehicles.get(type).add(vehicle);
        }
        return groupedVehicles;
    }    
    
    public static void main(String[] args) {


        // Create a list of vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Car", "Toyota", 80, 4));
        vehicles.add(new Car("Car", "Ford", 75, 2));
        vehicles.add(new Bike("Bike", "Yamaha", 100, 649));
        vehicles.add(new Bike("Bike", "Honda", 110, 0));


        // Print the vehicles before sorting
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.describe());
        }

        Collections.sort(vehicles);

        // Print the sorted vehicles by speed
        System.out.println("\nSorted by speed:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.describe());
        }

        // Sort vehicles by model name in alphabetical order
        vehicles.sort(Comparator.comparing(v -> v.getModel()));
        System.out.println("\nVehicles are in alphabetical order:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.describe());
        }

        // Group vehicles by type and print the count of each type
        HashMap<String, ArrayList<Vehicle>> groupedVehicles = groupByType(vehicles);
        for (String type : groupedVehicles.keySet()) {
            System.out.println(type + ": " + groupedVehicles.get(type).size() + " vehicles");
        }

        
    }
}

// Define the Vehicle class with Comparable interface to allow sorting by speed
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

// Define the Car class that extends Vehicle
class Car extends Vehicle {
    int numberOfDoors;

    public Car(String type, String model, int speed, int numberOfDoors) {
        super(type, model, speed);
        this.numberOfDoors = numberOfDoors;
    }

    // Override the describe method to include the number of doors
    @Override
    public String describe() {
        return super.describe() + " with " + numberOfDoors + " doors";
    }
}

// Define the Bike class that extends Vehicle
class Bike extends Vehicle {
        
    int cubicCapacity;

    public Bike(String type, String model, int speed, int cubicCapacity) {
        super(type, model, speed);
        this.cubicCapacity = cubicCapacity;
    }
    
    // Override the describe method to include the cubic capacity
    @Override
    public String describe() {
        return super.describe() + (cubicCapacity > 0 ? " and has a cubic capacity of " + cubicCapacity : " and does not have a cubic capacity");
    }
}

