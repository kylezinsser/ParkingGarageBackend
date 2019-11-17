package Garage;

import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingGarage {
    public List<ParkingSpot> availableSpots;
    public HashMap<ParkingSpot, Vehicle> occupiedSpots;

    public List<ParkingFloor> floors;
    private final int numOfFloors;

    public ParkingGarage(int numOfFloors, int numOfRows, int rowLength) {
        this.numOfFloors = numOfFloors;
        this.floors = generateFloors(numOfFloors, numOfRows, rowLength);
    }

    private List<ParkingFloor> generateFloors(int numOfFloors, int numOfRows, int rowLength) {
        List<ParkingFloor> floors = new ArrayList<ParkingFloor>();
        for(int i = 0; i < numOfFloors; i++) {
            floors.add(new ParkingFloor(numOfRows, rowLength));
        }
        return floors;
    }

//    private ParkingGarage generateGarage(int numOfFloors) {
//        if(garage == null){
//            garage = new ParkingGarage(numOfFloors);
//        }
//        return garage;
//    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void printDimensions() {
        System.out.println(numOfFloors);
    }



}
