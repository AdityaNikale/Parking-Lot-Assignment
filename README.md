# Parking Lot Management System

## Overview

This is a Java-based Parking Lot Management System designed to simulate the core operations of a parking lot. The project demonstrates object-oriented design principles, clean separation of concerns, exception handling, and a simple parking strategy.

## Features

- Park vehicles by ticketing them into available parking spots
- Unpark vehicles and release occupied parking spots
- Handle parking lot capacity limits with custom exceptions
- Support for different vehicle types (Car and Bike)
- Use of a parking strategy to decide spot allocation

## Project Structure

- `Main.java`
  - Application entry point for running the parking lot system

- `model/`
  - `Vehicle.java` - Abstract base class for vehicles
  - `Car.java` - Represents a car
  - `Bike.java` - Represents a bike
  - `ParkingSpot.java` - Represents a parking spot in the lot
  - `ParkingTicket.java` - Represents a ticket issued when parking a vehicle

- `service/`
  - `ParkingLotService.java` - Service interface defining parking operations
  - `ParkingLotServiceImpl.java` - Implementation of parking and unparking logic

- `repository/`
  - `ParkingLotRepository.java` - Data storage for parking spots and tickets

- `strategy/`
  - `ParkingStrategy.java` - Strategy interface for choosing parking spots
  - `NearestParkingStrategy.java` - Concrete strategy that selects the nearest available spot

- `exception/`
  - `ParkingLotFullException.java` - Thrown when the parking lot is full
  - `VehicleNotFoundException.java` - Thrown when attempting to unpark a vehicle not present in the lot

## How It Works

1. The application initializes a set of parking spots and a repository to manage them.
2. A parking strategy decides which free spot to allocate when a vehicle is parked.
3. When a vehicle is parked, a `ParkingTicket` is generated and returned.
4. When a vehicle is unparked, the ticket is used to locate the vehicle and free the spot.
5. Exceptions are used to handle invalid operations such as full parking or missing tickets.

## How to Run

From the project root directory, compile the project with Java:

```bash
javac Main.java model/*.java service/*.java repository/*.java strategy/*.java exception/*.java
```

Run the application:

```bash
java Main
```

> Note: If the project uses packages, update the compile and run commands to include package names or run from the source root accordingly.

## Design Notes

- The repository layer keeps parking data separate from business logic.
- The service layer implements the main parking behavior.
- The strategy pattern allows the parking allocation method to be changed with minimal code changes.
- Custom exceptions improve error handling and code readability.

## Extending This Project

Possible enhancements:

- Add support for more vehicle types such as trucks or electric vehicles
- Implement reservation or hourly billing features
- Add a graphical user interface or REST API
- Support different parking strategies such as random, nearest, or filling by size
