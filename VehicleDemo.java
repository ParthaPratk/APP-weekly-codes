import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String brand;
    double speed;

    Vehicle(String vehicleNumber, String brand, double speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    void displayDetails() {
        System.out.println("\nVehicle Number : " + vehicleNumber);
        System.out.println("Brand          : " + brand);
        System.out.println("Speed          : " + speed + " km/h");
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String vehicleNumber, String brand, double speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    void displayDetails() {
        System.out.println("\n--- Car Details ---");
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Brand          : " + brand);
        System.out.println("Speed          : " + speed + " km/h");
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}


class Bike extends Vehicle {
    boolean hasGear;

    Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    void displayDetails() {
        System.out.println("\n--- Bike Details ---");
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Brand          : " + brand);
        System.out.println("Speed          : " + speed + " km/h");

        if (hasGear)
            System.out.println("Has Gear       : Yes");
        else
            System.out.println("Has Gear       : No");
    }
}


public class VehicleDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("VEHICLE RENTAL SYSTEM");
        System.out.println("---------------------");

        // Car input
        System.out.println("\nEnter Car Details");

        System.out.print("Enter vehicle number: ");
        String carNumber = sc.nextLine();

        System.out.print("Enter brand: ");
        String carBrand = sc.nextLine();

        System.out.print("Enter speed: ");
        double carSpeed = sc.nextDouble();

        System.out.print("Enter number of doors: ");
        int doors = sc.nextInt();

        Car car = new Car(carNumber, carBrand, carSpeed, doors);

        sc.nextLine();

        System.out.println("\nEnter Bike Details");

        System.out.print("Enter vehicle number: ");
        String bikeNumber = sc.nextLine();

        System.out.print("Enter brand: ");
        String bikeBrand = sc.nextLine();

        System.out.print("Enter speed: ");
        double bikeSpeed = sc.nextDouble();

        System.out.print("Does the bike have gears? (true/false): ");
        boolean gear = sc.nextBoolean();

        Bike bike = new Bike(bikeNumber, bikeBrand, bikeSpeed, gear);

        
        Vehicle vehicle;

        System.out.println("\n\nDisplaying Car using Vehicle reference:");
        vehicle = car;
        vehicle.displayDetails();

        System.out.println("\nDisplaying Bike using Vehicle reference:");
        vehicle = bike;
        vehicle.displayDetails();

        sc.close();
    }
}