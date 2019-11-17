package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

public class Bus extends Vehicle {

    public Bus() {
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        vehicleId = UUID.randomUUID();
        vehicleType = VehicleType.BUS;
        consecutiveSpots = 5;
    }

}
