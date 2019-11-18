import Garage.ParkingGarage;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingApplication {
    private static final int minNumOfFloors = 1;
    private static final int minNumOfRows = 4;
    private static final int minRowLength = 16;

    private static final int maxNumOfFloors = 4;
    private static final int maxNumOfRows = 8;
    private static final int maxRowLength = 32;

    private static int numOfFloors = 0;
    private static int numOfRows = 0;
    private static int rowLength = 0;

    public static void main(String[] args) {
        randomizeGarageDimensions();
        ParkingGarage garage = new ParkingGarage(numOfFloors, numOfRows, rowLength);

        garage.printGarage();

        System.out.println("Garage has " + garage.getNumOfFloors() + " floors, with " + numOfRows + " rows per floor and " + rowLength + " units per row.");
        System.out.println();
        // ParkingGarage findSlot();






        List<Vehicle> parkingQueue = new ArrayList<>();
        for(int i=0; i < 10; i++) {
            parkingQueue.add(Vehicle.getRandomVehicle());
        }

        System.out.println("Parking queue processing: ");
        for(Vehicle v: parkingQueue) {
            boolean parked = garage.parkVehicle(v);
            if(parked) {
                System.out.println("Vehicle #:" + v.getVehicleId() + " of type " + v.getVehicleType() + " has entered the garage and parked in slot(s) " + v.getOccupiedSpots());
            } else {
                System.out.println("Vehicle #:" + v.getVehicleId() + " of type " + v.getVehicleType() + " has entered the garage and is waiting in the queue.");
            }
        }

        garage.printGarage();




    }

    // TODO: move to ParkingGarage?
    private static void randomizeGarageDimensions() {
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
    }

}
