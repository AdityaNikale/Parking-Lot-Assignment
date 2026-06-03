package repository;

import model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {

    private final List<ParkingSpot> parkingSpots;

    public ParkingLotRepository(int totalSpots) {

        parkingSpots = new ArrayList<>();

        for (int i = 1; i <= totalSpots; i++) {
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}