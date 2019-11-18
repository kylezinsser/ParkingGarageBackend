package Vehicles;

import Garage.ParkingSpot;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

// Went with an abstract class instead of interface because the vehicles act identically other than their attributes
// No sense in duplicating code for the behavior
public abstract class Vehicle {
    // Enum for the types of vehicles
    public enum VehicleType {
        MOTORCYCLE,
        CAR,
        BUS
    }

    private List<ParkingSpot> occupiedSpots = new ArrayList<>();
    List<ParkingSpot.SpotType> compatibleSpots = new ArrayList<>();
    VehicleType vehicleType;
    int consecutiveSpots;
    UUID vehicleId;

    // Method to return a random Vehicle
    public static Vehicle getRandomVehicle() {
        Random random = new Random();
        Vehicle vehicle;

        VehicleType[] types = VehicleType.values();
        VehicleType randomChoice = types[random.nextInt(types.length)];

        // Switch on the randomChoice to return one of the Vehicle subclasses
        switch (randomChoice) {
            case MOTORCYCLE:
                vehicle = new Motorcycle();
                break;
            case CAR:
                vehicle = new Car();
                break;
            case BUS: // Fallthrough to default since we shouldn't get any other value
            default:
                vehicle = new Bus();
                break;
        }
        return vehicle;
    }

    // TODO: May want to move some of the parking logic from the controller to here later on

    // Returns the spot name(s) as a String for the console print statements
    public String getOccupiedSpotNames() {
        StringBuilder s = new StringBuilder();
        for (ParkingSpot spot : occupiedSpots) {
            s.append(spot.getSpotLookup()).append(", ");
        }
        return s.toString();
    }

    // Basic getters and setters follow
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

    public void setOccupiedSpots(List<ParkingSpot> occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
    }

    public List<ParkingSpot> getOccupiedSpots() {
        return occupiedSpots;
    }
}
