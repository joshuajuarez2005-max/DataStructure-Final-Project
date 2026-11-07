
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackDemo {

    public static void showMenu(List<Vehicle> originalVehicles,
                                Scanner input) {

        // Create a temporary Stack
        Stack<Vehicle> vehicles =
                new Stack<>();

        //  original vehicles into the Stack
        for (Vehicle vehicle : originalVehicles) {
            vehicles.push(vehicle);
        }

        int choice;

        do {
            System.out.println("\n========== STACK ==========");
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Add Vehicle (Push)");
            System.out.println("3. Remove Top Vehicle (Pop)");
            System.out.println("4. View Top Vehicle (Peek)");
            System.out.println("5. Check Stack Size");
            System.out.println("6. Check if Stack is Empty");
            System.out.println("7. Return to Main Menu");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nVEHICLES IN STACK");

                    if (vehicles.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        for (int i = vehicles.size() - 1; i >= 0; i--) {
                            System.out.println(vehicles.get(i));
                        }
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

                    Vehicle newVehicle =
                            new Vehicle(id, name, brand, price);

                    vehicles.push(newVehicle);

                    System.out.println("Vehicle added to the Stack!");
                    break;

                case 3:
                    if (vehicles.isEmpty()) {
                        System.out.println("Stack is empty. Nothing to remove.");
                    } else {
                        Vehicle removedVehicle = vehicles.pop();

                        System.out.println("Removed vehicle:");
                        System.out.println(removedVehicle);
                    }
                    break;

                case 4:
                    if (vehicles.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        Vehicle topVehicle = vehicles.peek();

                        System.out.println("Top vehicle:");
                        System.out.println(topVehicle);
                    }
                    break;

                case 5:
                    System.out.println("Total vehicles in Stack: "
                            + vehicles.size());
                    break;

                case 6:
                    if (vehicles.isEmpty()) {
                        System.out.println("The Stack is empty.");
                    } else {
                        System.out.println("The Stack is not empty.");
                    }
                    break;

                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }
}
