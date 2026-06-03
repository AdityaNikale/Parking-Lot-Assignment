package model;

public class Car extends Vehicle {

    public Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }
}