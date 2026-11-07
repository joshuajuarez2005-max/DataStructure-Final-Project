
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListDemo {

    public static void showMenu(List<Vehicle> originalVehicles,
                                Scanner input) {

        // Create a temporary LinkedList
        LinkedList<Vehicle> vehicles =
                new LinkedList<>(originalVehicles);

        int choice;

        do {
            System.out.println("\n========== LINKEDLIST ==========");
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Add a Vehicle");
            System.out.println("3. Remove a Vehicle");
            System.out.println("4. Get Vehicle by Index");
            System.out.println("5. Traverse Forward (Iterator)");
            System.out.println("6. Traverse Backward (ListIterator)");
            System.out.println("7. Check List Size");
            System.out.println("8. Return to Main Menu");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nVEHICLES IN LINKEDLIST");
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

                    Iterator<Vehicle> removeIterator =
                            vehicles.iterator();

                    while (removeIterator.hasNext()) {
                        Vehicle vehicle = removeIterator.next();

                        if (vehicle.getVehicleID()
                                .equalsIgnoreCase(removeID)) {

                            removeIterator.remove();
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
                    System.out.println("\nFORWARD TRAVERSAL");

                    Iterator<Vehicle> iterator =
                            vehicles.iterator();

                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;

                case 6:
                    System.out.println("\nBACKWARD TRAVERSAL");

                    ListIterator<Vehicle> listIterator =
                            vehicles.listIterator(vehicles.size());

                    while (listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous());
                    }
                    break;

                case 7:
                    System.out.println("Total vehicles: "
                            + vehicles.size());
                    break;

                case 8:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }
}
