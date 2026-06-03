package strategy;

import model.ParkingSpot;

import java.util.List;

public class NearestParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findAvailableSpot(
            List<ParkingSpot> parkingSpots) {

        for (ParkingSpot spot : parkingSpots) {

            if (spot.isAvailable()) {
                return spot;
            }
        }

        return null;
    }
}