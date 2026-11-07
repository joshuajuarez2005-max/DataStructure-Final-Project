
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // let's ;load the original dataset
        List<Vehicle> originalVehicles =
                VehicleData.getOriginalData();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("  VEHICLE DATA STRUCTURES EXPLORER");
            System.out.println("=================================");

            System.out.println("1. View Original Data");
            System.out.println("2. Searching");
            System.out.println("3. Sorting");
            System.out.println("4. ArrayList");
            System.out.println("5. LinkedList");
            System.out.println("6. Queue");
            System.out.println("7. Stack");
            System.out.println("8. Hash Table");
            System.out.println("9. Binary Search Tree");
            System.out.println("10. Heap");
            System.out.println("11. Graph");
            System.out.println("12. Exit");

            System.out.print("\nEnter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nORIGINAL VEHICLE DATA");
                    System.out.println("---------------------------------");

                    for (Vehicle vehicle : originalVehicles) {
                        System.out.println(vehicle);
                    }
                    break;

                case 2:
                    System.out.println("Searching module coming soon.");
                    break;

                case 3:
                    System.out.println("Sorting module coming soon.");
                    break;

                case 4:
                    System.out.println("ArrayList module coming soon.");
                    break;

                case 5:
                    System.out.println("LinkedList module coming soon.");
                    break;

                case 6:
                    System.out.println("Queue module coming soon.");
                    break;

                case 7:
                    System.out.println("Stack module coming soon.");
                    break;

                case 8:
                    System.out.println("Hash Table module coming soon.");
                    break;

                case 9:
                    System.out.println("Binary Search Tree module coming soon.");
                    break;

                case 10:
                    System.out.println("Heap module coming soon.");
                    break;

                case 11:
                    System.out.println("Graph module coming soon.");
                    break;

                case 12:
                    System.out.println("Thank you for using Vehicle Data Structures Explorer!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 12);

        input.close();
    }
}
