package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

public class Car extends Vehicle {

    public Car() {
        compatibleSpots.add(ParkingSpot.SpotType.COMPACT);
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        vehicleId = UUID.randomUUID();
        type = VehicleType.CAR;
        consecutiveSpots = 1;
    }

}
