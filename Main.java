import model.Bike;
import model.Car;
import model.ParkingTicket;
import model.Vehicle;
import repository.ParkingLotRepository;
import service.ParkingLotService;
import service.ParkingLotServiceImpl;
import strategy.NearestParkingStrategy;
import strategy.ParkingStrategy;

public class Main {

    public static void main(String[] args) {

        // Repository Layer
        ParkingLotRepository repository =
                new ParkingLotRepository(5);

        // Strategy Layer
        ParkingStrategy parkingStrategy =
                new NearestParkingStrategy();

        // Service Layer
        ParkingLotService parkingLotService =
                new ParkingLotServiceImpl(
                        repository,
                        parkingStrategy
                );

        // Vehicles
        Vehicle car =
                new Car("MH12AB1234");

        Vehicle bike =
                new Bike("MH14XY5678");

        System.out.println("===== PARKING VEHICLES =====");

        ParkingTicket carTicket =
                parkingLotService.parkVehicle(car);

        ParkingTicket bikeTicket =
                parkingLotService.parkVehicle(bike);

        System.out.println();

        System.out.println("===== PARKING STATUS =====");

        parkingLotService.displayParkingStatus();

        System.out.println();

        System.out.println("===== REMOVE VEHICLE =====");

        parkingLotService.removeVehicle(
                "MH12AB1234"
        );

        System.out.println();

        System.out.println("===== PARKING STATUS AFTER EXIT =====");

        parkingLotService.displayParkingStatus();

        System.out.println();

        System.out.println("===== GENERATED TICKETS =====");

        System.out.println(
                "Car Ticket ID : "
                        + carTicket.getTicketId()
        );

        System.out.println(
                "Bike Ticket ID : "
                        + bikeTicket.getTicketId()
        );
    }
}