
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleData {

    public static List<Vehicle> getOriginalData() {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle("S101", "Civic", "Honda", 25000));
        vehicles.add(new Vehicle("S102", "Accord", "Honda", 32000));
        vehicles.add(new Vehicle("S103", "Camry", "Toyota", 28000));
        vehicles.add(new Vehicle("S104", "Corolla", "Toyota", 23000));
        vehicles.add(new Vehicle("S105", "Model 3", "Tesla", 39000));
        vehicles.add(new Vehicle("S106", "Model Y", "Tesla", 45000));
        vehicles.add(new Vehicle("S107", "CR-V", "Honda", 31000));
        vehicles.add(new Vehicle("S108", "RAV4", "Toyota", 34000));
        vehicles.add(new Vehicle("S109", "Mustang", "Ford", 42000));
        vehicles.add(new Vehicle("S110", "Escape", "Ford", 30000));

        // Protecting the original dataset from modification
        return Collections.unmodifiableList(vehicles);
    }
}
