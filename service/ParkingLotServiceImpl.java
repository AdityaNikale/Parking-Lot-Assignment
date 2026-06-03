package service;

import exception.ParkingLotFullException;
import exception.VehicleNotFoundException;
import model.ParkingSpot;
import model.ParkingTicket;
import model.Vehicle;
import repository.ParkingLotRepository;
import strategy.ParkingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository repository;
    private final ParkingStrategy parkingStrategy;


    private final Map<String, ParkingSpot> vehicleSpotMap;

    public ParkingLotServiceImpl(ParkingLotRepository repository, ParkingStrategy parkingStrategy) {

        this.repository = repository;
        this.parkingStrategy = parkingStrategy;
        this.vehicleSpotMap = new HashMap<>();
    }

    @Override
    public ParkingTicket parkVehicle(Vehicle vehicle) {

        List<ParkingSpot> parkingSpots = repository.getParkingSpots();

        ParkingSpot availableSpot = parkingStrategy.findAvailableSpot(parkingSpots);

        if (availableSpot == null) {
            throw new ParkingLotFullException(
                    "Parking Lot is Full"
            );
        }

        availableSpot.assignVehicle(vehicle);

        vehicleSpotMap.put(vehicle.getRegistrationNumber(), availableSpot);

        ParkingTicket ticket = new ParkingTicket(vehicle, availableSpot);

        System.out.println("Vehicle Parked Successfully");

        System.out.println("Spot Number : "+ availableSpot.getSpotId());

        System.out.println("Ticket ID : " + ticket.getTicketId());

        return ticket;
    }

    @Override
    public void removeVehicle(String registrationNumber) {

        ParkingSpot parkingSpot = vehicleSpotMap.get(registrationNumber);

        if (parkingSpot == null) {

            throw new VehicleNotFoundException("Vehicle not found : " + registrationNumber);
        }

        parkingSpot.removeVehicle();

        vehicleSpotMap.remove(registrationNumber);

        System.out.println("Vehicle Removed Successfully : " + registrationNumber);
    }

    @Override
    public void displayParkingStatus() {

        List<ParkingSpot> parkingSpots = repository.getParkingSpots();

        for (ParkingSpot spot : parkingSpots) {

            if (spot.isAvailable()) {

                System.out.println("Spot " + spot.getSpotId() + " -> Available");

            } else {

                System.out.println("Spot " + spot.getSpotId() + " -> " + spot.getParkedVehicle().getRegistrationNumber());
            }
        }
    }
}