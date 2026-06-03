package strategy;

import model.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {

    ParkingSpot findAvailableSpot(
            List<ParkingSpot> parkingSpots);
}