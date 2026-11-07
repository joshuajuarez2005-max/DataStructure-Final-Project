

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Searching {

    // Linear Search
    public static Vehicle linearSearch(List<Vehicle> vehicles, String targetID) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVehicleID().equalsIgnoreCase(targetID)) {
                return vehicle;
            }
        }

        return null;
    }

    // Binary Search
    public static Vehicle binarySearch(List<Vehicle> vehicles, String targetID) {

        // Creating a temporary copy and sort it by Vehicle ID
        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);

        sortedVehicles.sort(Comparator.comparing(Vehicle::getVehicleID));

        int left = 0;
        int right = sortedVehicles.size() - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            Vehicle middleVehicle = sortedVehicles.get(middle);

            int comparison = middleVehicle.getVehicleID()
                    .compareToIgnoreCase(targetID);

            if (comparison == 0) {
                return middleVehicle;
            }

            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }

    // Searching Menu
    public static void showMenu(List<Vehicle> vehicles, Scanner input) {

        int choice;

        do {
            System.out.println("\n========== SEARCHING ==========");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Return to Main Menu");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1 || choice == 2) {

                System.out.print("Enter Vehicle ID (example S105): ");
                String targetID = input.nextLine();

                Vehicle result;

                if (choice == 1) {
                    result = linearSearch(vehicles, targetID);
                    System.out.println("\nUsing Linear Search...");
                } else {
                    result = binarySearch(vehicles, targetID);
                    System.out.println("\nUsing Binary Search...");
                }

                if (result != null) {
                    System.out.println("Vehicle Found!");
                    System.out.println(result);
                } else {
                    System.out.println("Vehicle not found.");
                }

            } else if (choice != 3) {
                System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }
}
