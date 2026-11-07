
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListDemo {

    public static void showMenu(List<Vehicle> originalVehicles,
                                Scanner input) {

        // Create a temporary ArrayList
        ArrayList<Vehicle> vehicles =
                new ArrayList<>(originalVehicles);

        int choice;

        do {
            System.out.println("\n========== ARRAYLIST ==========");
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Add a Vehicle");
            System.out.println("3. Remove a Vehicle");
            System.out.println("4. Get Vehicle by Index");
            System.out.println("5. Check List Size");
            System.out.println("6. Return to Main Menu");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nVEHICLES IN ARRAYLIST");
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle);
                    }
                    break;

                case 2:
                    System.out.print("Enter Vehicle ID: ");
                    String id = input.nextLine();

                    System.out.print("Enter Vehicle Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Brand: ");
                    String brand = input.nextLine();

                    System.out.print("Enter Price: ");
                    double price = input.nextDouble();
                    input.nextLine();

                    vehicles.add(
                        new Vehicle(id, name, brand, price)
                    );

                    System.out.println("Vehicle added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Vehicle ID to remove: ");
                    String removeID = input.nextLine();

                    boolean removed = false;

                    for (int i = 0; i < vehicles.size(); i++) {

                        if (vehicles.get(i).getVehicleID()
                                .equalsIgnoreCase(removeID)) {

                            vehicles.remove(i);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Vehicle removed successfully!");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter an index (0 to "
                            + (vehicles.size() - 1) + "): ");

                    int index = input.nextInt();

                    if (index >= 0 && index < vehicles.size()) {
                        System.out.println("Vehicle at index " + index + ":");
                        System.out.println(vehicles.get(index));
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 5:
                    System.out.println("Total vehicles: "
                            + vehicles.size());
                    break;

                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }
}
