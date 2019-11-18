package Garage;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {
    // Create a list of available spots
    private List<ParkingSpot> availableSpots;
    // Create a list of occupied spots. May want to use a HashMap in the future to pair spot with its vehicle
    private List<ParkingSpot> occupiedSpots;
    // List to contain floor objects
    private List<ParkingFloor> floors;
    private final int numOfFloors;

    // Constructor just initializes private variables using passed values
    public ParkingGarage(int numOfFloors, int numOfRows, int rowLength) {
        this.numOfFloors = numOfFloors;
        this.floors = generateFloors(numOfFloors, numOfRows, rowLength);
        this.availableSpots = listAvailableSpots();
        this.occupiedSpots = new ArrayList<>();
    }

    // We need to create a set of floors for each new ParkingGarage object
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
                    // if occupy status is false then it is available
                    if (!spot.getOccupyStatus()) {
                        available.add(spot);
                    }
                }
            }
        }
        return available;
    }

    // Print commands are passed on to each floor
    public void printGarage() {
        for (ParkingFloor floor : floors) {
            floor.printFloor();
        }
    }

    // Basic getters and setters follow
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

    public int getNumOfFloors() {
        return numOfFloors;
    }
}
