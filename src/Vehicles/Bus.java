package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

// Basic bus subclass
class Bus extends Vehicle {

    Bus() {
        // Assign compatible spots
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        // Generate a UUID
        vehicleId = UUID.randomUUID();
        // Assign vehicle type
        vehicleType = VehicleType.BUS;
        // Assign consecutive spot requirement
        consecutiveSpots = 5;
    }

}
