package Vehicles;

import Garage.ParkingSpot;

import java.util.UUID;

class Bus extends Vehicle {

    Bus() {
        compatibleSpots.add(ParkingSpot.SpotType.LARGE);

        vehicleId = UUID.randomUUID();
        vehicleType = VehicleType.BUS;
        consecutiveSpots = 5;
    }

}
