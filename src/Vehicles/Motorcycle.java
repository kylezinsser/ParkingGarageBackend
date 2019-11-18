package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

// Basic motorcycle subclass
class Motorcycle extends Vehicle {

    Motorcycle() {
        // Assign compatible spots
        compatibleSpots.add(ParkingSpot.SpotType.SMALL);
        compatibleSpots.add(ParkingSpot.SpotType.COMPACT);
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        // Generate a UUID
        vehicleId = UUID.randomUUID();
        // Assign vehicle type
        vehicleType = VehicleType.MOTORCYCLE;
        // Assign consecutive spot requirement
        consecutiveSpots = 1;
    }

}
