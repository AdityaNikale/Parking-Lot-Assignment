package model;

public class Bike extends Vehicle {

    public Bike(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}