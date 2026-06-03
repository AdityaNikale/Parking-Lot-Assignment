package model;

public class ParkingSpot {

    private final int spotId;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
    }

    public int getSpotId() {
        return spotId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
    }
}