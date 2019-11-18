package Garage;

import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingGarage {
    public List<ParkingSpot> availableSpots;
    public List<ParkingSpot> occupiedSpots;
//    public HashMap<ParkingSpot, Vehicle> occupiedSpots;

    private List<ParkingFloor> floors;
    private final int numOfFloors;

    public ParkingGarage(int numOfFloors, int numOfRows, int rowLength) {
        this.numOfFloors = numOfFloors;
        this.floors = generateFloors(numOfFloors, numOfRows, rowLength);
        this.availableSpots = calcAvailableSpots();
        this.occupiedSpots = new ArrayList<>();
    }

    private List<ParkingFloor> generateFloors(int numOfFloors, int numOfRows, int rowLength) {
        List<ParkingFloor> floors = new ArrayList<>();
        for(int i = 0; i < numOfFloors; i++) {
            floors.add(new ParkingFloor(i, numOfRows, rowLength));
        }
        return floors;
    }

    private List<ParkingSpot> calcAvailableSpots() {
        List<ParkingSpot> available = new ArrayList<>();

        for (ParkingFloor floor : floors) {
            List<ParkingRow> rows = floor.getRows();
            for (ParkingRow row : rows) {
                List<ParkingSpot> spots = row.getSpots();
                for (ParkingSpot spot : spots) {
                    if (spot.getOccupyStatus() == false) {
                        available.add(spot);
                    }
                }
            }
        }

        return available;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void printGarage() {
        for (ParkingFloor floor : floors) {
            floor.printFloor();
        }
    }

    public boolean parkVehicle(Vehicle v) {
        for (ParkingSpot spot : availableSpots) {
            if (v.getCompatibleSpots().contains(spot.getSpotType())) {
                spot.setOccupyStatus(true);
                v.getOccupiedSpots().add(spot);

                occupiedSpots.add(spot);
                availableSpots.remove(spot);
                return true;
            }
        }
        return false;
    }


}
