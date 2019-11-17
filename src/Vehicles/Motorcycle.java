package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

public class Motorcycle extends Vehicle {

    public Motorcycle() {
        compatibleSpots.add(ParkingSpot.SpotType.SMALL);
        compatibleSpots.add(ParkingSpot.SpotType.COMPACT);
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        vehicleId = UUID.randomUUID();
        vehicleType = VehicleType.MOTORCYCLE;
        consecutiveSpots = 1;
    }

}
