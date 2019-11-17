import Garage.ParkingGarage;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingApplication {
    public static final int minNumOfFloors = 1;
    public static final int minNumOfRows = 4;
    public static final int minRowLength = 15;

    public static final int maxNumOfFloors = 10;
    public static final int maxNumOfRows = 10;
    public static final int maxRowLength = 40;

    public static int numOfFloors = 0;
    public static int numOfRows = 0;
    public static int rowLength = 0;

    public static void main(String[] args) {
//        List<Vehicle> parkingQueue = new ArrayList<Vehicle>();
//
//        for(int i=0; i < 10; i++) {
//            parkingQueue.add(Vehicle.getRandomVehicle());
//        }
//
//        System.out.println("Parking queue processing: ");
//        for(Vehicle v: parkingQueue) {
//            System.out.println("Vehicle #:" + v.getVehicleId() + " of type " + v.getVehicleType() + " has entered the garage and parked in slot(s) " + v.getOccupiedSpots());
//        }

        Random random = new Random();
        if(numOfFloors == 0) {
            numOfFloors = random.nextInt(maxNumOfFloors - minNumOfFloors) + minNumOfFloors;
        }
        if(numOfRows == 0) {
            numOfRows = random.nextInt(maxNumOfRows - minNumOfRows) + minNumOfRows;
        }
        if(rowLength == 0) {
            rowLength = random.nextInt(maxRowLength - minRowLength) + minRowLength;
        }
        ParkingGarage garage = new ParkingGarage(numOfFloors, numOfRows, rowLength);

        System.out.println("Garage has " + garage.getNumOfFloors() + " floors, with " + numOfRows + " rows per floor and " + rowLength + " units per row.");
        // ParkingGarage findSlot();
    }

}
