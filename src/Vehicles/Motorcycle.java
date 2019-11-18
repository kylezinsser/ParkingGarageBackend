package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

class Motorcycle extends Vehicle {

    Motorcycle() {
        compatibleSpots.add(ParkingSpot.SpotType.SMALL);
        compatibleSpots.add(ParkingSpot.SpotType.COMPACT);
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        vehicleId = UUID.randomUUID();
        vehicleType = VehicleType.MOTORCYCLE;
        consecutiveSpots = 1;
    }

}
