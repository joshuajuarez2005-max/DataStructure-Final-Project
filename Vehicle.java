
public class Vehicle {

    // Vehicle information
    private String vehicleID;
    private String vehicleName;
    private String brand;
    private double price;

    // Constructor
    public Vehicle(String vehicleID, String vehicleName,
                   String brand, double price) {

        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.brand = brand;
        this.price = price;
    }

    // Getters
    public String getVehicleID() {
        return vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    // Display vehicle information
    @Override
    public String toString() {
        return vehicleID + " | " + vehicleName +
               " | " + brand + " | $" + price;
    }
}
