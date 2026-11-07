
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorting {

    // Display vehicles
    public static void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Bubble Sort
    public static void bubbleSort(List<Vehicle> vehicles) {

        int n = vehicles.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (vehicles.get(j).getPrice() >
                    vehicles.get(j + 1).getPrice()) {

                    Vehicle temp = vehicles.get(j);

                    vehicles.set(j, vehicles.get(j + 1));
                    vehicles.set(j + 1, temp);
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(List<Vehicle> vehicles,
                                 int low, int high) {

        if (low < high) {

            int pivotIndex = partition(vehicles, low, high);

            quickSort(vehicles, low, pivotIndex - 1);
            quickSort(vehicles, pivotIndex + 1, high);
        }
    }

    // Partition method for Quick Sort
    private static int partition(List<Vehicle> vehicles,
                                 int low, int high) {

        double pivot = vehicles.get(high).getPrice();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (vehicles.get(j).getPrice() <= pivot) {

                i++;

                Vehicle temp = vehicles.get(i);
                vehicles.set(i, vehicles.get(j));
                vehicles.set(j, temp);
            }
        }

        Vehicle temp = vehicles.get(i + 1);
        vehicles.set(i + 1, vehicles.get(high));
        vehicles.set(high, temp);

        return i + 1;
    }

    // Merge Sort
    public static void mergeSort(List<Vehicle> vehicles) {

        if (vehicles.size() <= 1) {
            return;
        }

        int middle = vehicles.size() / 2;

        List<Vehicle> left = new ArrayList<>(
                vehicles.subList(0, middle));

        List<Vehicle> right = new ArrayList<>(
                vehicles.subList(middle, vehicles.size()));

        mergeSort(left);
        mergeSort(right);

        merge(vehicles, left, right);
    }

    // Merge two sorted lists
    private static void merge(List<Vehicle> vehicles,
                              List<Vehicle> left,
                              List<Vehicle> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i).getPrice() <= right.get(j).getPrice()) {

                vehicles.set(k, left.get(i));
                i++;

            } else {

                vehicles.set(k, right.get(j));
                j++;
            }

            k++;
        }

        while (i < left.size()) {
            vehicles.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            vehicles.set(k, right.get(j));
            j++;
            k++;
        }
    }

    // Sorting Menu
    public static void showMenu(List<Vehicle> originalVehicles,
                                Scanner input) {

        int choice;

        do {
            System.out.println("\n========== SORTING ==========");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Merge Sort");
            System.out.println("4. Return to Main Menu");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            List<Vehicle> temporaryVehicles =
                    new ArrayList<>(originalVehicles);

            switch (choice) {

                case 1:
                    bubbleSort(temporaryVehicles);

                    System.out.println("\nBUBBLE SORT RESULTS");
                    displayVehicles(temporaryVehicles);
                    break;

                case 2:
                    quickSort(temporaryVehicles, 0,
                              temporaryVehicles.size() - 1);

                    System.out.println("\nQUICK SORT RESULTS");
                    displayVehicles(temporaryVehicles);
                    break;

                case 3:
                    mergeSort(temporaryVehicles);

                    System.out.println("\nMERGE SORT RESULTS");
                    displayVehicles(temporaryVehicles);
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }
}
