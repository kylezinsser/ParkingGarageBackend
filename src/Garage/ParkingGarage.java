package Garage;

import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingGarage {
    private List<ParkingSpot> availableSpots;
    private List<ParkingSpot> occupiedSpots;
//    public HashMap<ParkingSpot, Vehicle> occupiedSpots;

    private List<ParkingFloor> floors;
    private final int numOfFloors;

    public ParkingGarage(int numOfFloors, int numOfRows, int rowLength) {
        this.numOfFloors = numOfFloors;
        this.floors = generateFloors(numOfFloors, numOfRows, rowLength);
        this.availableSpots = listAvailableSpots();
        this.occupiedSpots = new ArrayList<>();
    }

    private List<ParkingFloor> generateFloors(int numOfFloors, int numOfRows, int rowLength) {
        List<ParkingFloor> floors = new ArrayList<>();
        for(int i = 0; i < numOfFloors; i++) {
            floors.add(new ParkingFloor(i, numOfRows, rowLength));
        }
        return floors;
    }

    // Checks component parts to get a list of each available spot
    private List<ParkingSpot> listAvailableSpots() {
        List<ParkingSpot> available = new ArrayList<>();

        // Ideally we'd have a simple DB call instead of nesting loops through each child component
        for (ParkingFloor floor : floors) {
            List<ParkingRow> rows = floor.getRows();
            // Iterate through each row per floor
            for (ParkingRow row : rows) {
                List<ParkingSpot> spots = row.getSpots();
                // Iterate through each spot per row
                for (ParkingSpot spot : spots) {
                    // if spot isOccupied==false it is available
                    if (!spot.getOccupyStatus()) {
                        available.add(spot);
                    }
                }
            }
        }
        return available;
    }

    public void printGarage() {
        for (ParkingFloor floor : floors) {
            floor.printFloor();
        }
    }

//    public boolean parkVehicle(Vehicle v) {
//        for (ParkingSpot spot : availableSpots) {
//            if (v.getCompatibleSpots().contains(spot.getSpotType())) {
//                spot.setOccupyStatus(true);
//                v.getOccupiedSpots().add(spot);
//
//                occupiedSpots.add(spot);
//                availableSpots.remove(spot);
//                return true;
//            }
//        }
//        return false;
//    }

    public List<ParkingSpot> getAvailableSpots() {
        return availableSpots;
    }

    public List<ParkingSpot> getOccupiedSpots() {
        return occupiedSpots;
    }

    public void setAvailableSpots(List<ParkingSpot> availableSpots) {
        this.availableSpots = availableSpots;
    }

    public void setOccupiedSpots(List<ParkingSpot> occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }
}
