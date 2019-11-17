package Vehicles;

import Garage.ParkingSpot;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public abstract class Vehicle {

    public enum VehicleType {
        MOTORCYCLE,
        CAR,
        BUS
    }

    protected UUID vehicleId;
    protected VehicleType vehicleType;
    protected int consecutiveSpots;
    protected List<ParkingSpot.SpotType> compatibleSpots = new ArrayList<ParkingSpot.SpotType>();
    protected List<ParkingSpot> occupiedSpots = new ArrayList<ParkingSpot>();

    public UUID getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getConsecutiveSpots() {
        return consecutiveSpots;
    }

    public List<ParkingSpot.SpotType> getCompatibleSpots() {
        return compatibleSpots;
    }

    public List<ParkingSpot> getOccupiedSpots() {
        return occupiedSpots;
    }

    public static Vehicle getRandomVehicle() {
        Random random = new Random();
        Vehicle vehicle = null;

        VehicleType[] types = VehicleType.values();
        VehicleType randomChoice = types[random.nextInt(types.length)];
        switch (randomChoice) {
            case MOTORCYCLE:
                vehicle = new Motorcycle();
                break;
            case CAR:
                vehicle = new Car();
                break;
            case BUS:
                vehicle = new Bus();
                break;
        }

        return vehicle;
    }
}
