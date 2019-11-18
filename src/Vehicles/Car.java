package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

// Basic car subclass
class Car extends Vehicle {

    Car() {
        // Assign compatible spots
        compatibleSpots.add(ParkingSpot.SpotType.COMPACT);
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        // Generate a UUID
        vehicleId = UUID.randomUUID();
        // Assign vehicle type
        vehicleType = VehicleType.CAR;
        // Assign consecutive spot requirement
        consecutiveSpots = 1;
    }

}
