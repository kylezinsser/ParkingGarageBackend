package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

class Car extends Vehicle {

    Car() {
        compatibleSpots.add(ParkingSpot.SpotType.COMPACT);
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        vehicleId = UUID.randomUUID();
        vehicleType = VehicleType.CAR;
        consecutiveSpots = 1;
    }

}
