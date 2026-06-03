package service;

import model.ParkingTicket;
import model.Vehicle;

public interface ParkingLotService {

    ParkingTicket parkVehicle(Vehicle vehicle);

    void removeVehicle(String registrationNumber);

    void displayParkingStatus();
}