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

    UUID vehicleId;
    VehicleType vehicleType;
    int consecutiveSpots;
    List<ParkingSpot.SpotType> compatibleSpots = new ArrayList<>();
    private List<ParkingSpot> occupiedSpots = new ArrayList<>();

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

    public String getOccupiedSpotNames() {
        StringBuilder s = new StringBuilder();
        for (ParkingSpot spot : occupiedSpots) {
            s.append(spot.getSpotLookup()).append(", ");
        }
        return s.toString();
    }

    public List<ParkingSpot> getOccupiedSpots() {
        return occupiedSpots;
    }

    public void setOccupiedSpots(List<ParkingSpot> occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
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
