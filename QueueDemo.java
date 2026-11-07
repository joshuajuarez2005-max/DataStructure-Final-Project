
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class QueueDemo {

    public static void showMenu(List<Vehicle> originalVehicles,
                                Scanner input) {

        // a temporary Queue
        Queue<Vehicle> vehicles =
                new LinkedList<>(originalVehicles);

        int choice;

        do {
            System.out.println("\n========== QUEUE ==========");
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Add a Vehicle (Offer)");
            System.out.println("3. Process Next Vehicle (Poll)");
            System.out.println("4. View Next Vehicle (Peek)");
            System.out.println("5. Check Queue Size");
            System.out.println("6. Check if Queue is Empty");
            System.out.println("7. Return to Main Menu");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nVEHICLES IN QUEUE");

                    if (vehicles.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        for (Vehicle vehicle : vehicles) {
                            System.out.println(vehicle);
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

                    vehicles.offer(newVehicle);

                    System.out.println("Vehicle added to the queue!");
                    break;

                case 3:
                    Vehicle processedVehicle = vehicles.poll();

                    if (processedVehicle == null) {
                        System.out.println("Queue is empty. Nothing to process.");
                    } else {
                        System.out.println("Processed vehicle:");
                        System.out.println(processedVehicle);
                    }
                    break;

                case 4:
                    Vehicle nextVehicle = vehicles.peek();

                    if (nextVehicle == null) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Next vehicle to be processed:");
                        System.out.println(nextVehicle);
                    }
                    break;

                case 5:
                    System.out.println("Total vehicles in queue: "
                            + vehicles.size());
                    break;

                case 6:
                    if (vehicles.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("The queue is not empty.");
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
