import Garage.ParkingGarage;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingApplication {
    // Included min and max dimensions for easy experimentation
    // Declaring minimum values for each garage dimension
    private static final int minNumOfFloors = 1;
    private static final int minNumOfRows = 4;
    private static final int minRowLength = 12;

    // Declaring maximum values for each garage dimension
    private static final int maxNumOfFloors = 4;
    private static final int maxNumOfRows = 8;
    private static final int maxRowLength = 24;

    // We will use random values in each dimension
    private static Random random = new Random();
    private static int numOfFloors = random.nextInt(maxNumOfFloors - minNumOfFloors) + minNumOfFloors;
    private static int numOfRows = random.nextInt(maxNumOfRows - minNumOfRows) + minNumOfRows;
    private static int rowLength = random.nextInt(maxRowLength - minRowLength) + minRowLength;

    // For this exercise we will have the main method perform a series of garage functions
    // In a complete application we'd basically have a running service listening for user input instead
    public static void main(String[] args) {
        // Create a parking controller with the random dimensions we've assigned
        ParkingController myGarage = new ParkingController(numOfFloors, numOfRows, rowLength);

        // Print the initial layout of the garage to the console
        // Open spaces represented by "O"s within square brackets that vary in length based on small, compact, or large
        System.out.println("\nInitial garage status (O = Open, X = Occupied): ");
        myGarage.printParkingStructure();

        // We'll generate a random number of cars to try parking
        int queueLength = random.nextInt((numOfFloors * numOfRows * rowLength) / 2) + 40;
        System.out.println("Garage has " + queueLength + " cars trying to park.\n");

        // In a real application we'd probably use the Queue interface to ensure FIFO
        List<Vehicle> parkingQueue = new ArrayList<>();
        for(int i=0; i < queueLength; i++) {
            parkingQueue.add(Vehicle.getRandomVehicle());
        }

        // Keep track of some simple counters to display at the end
        int parkedVehicles = 0;
        int waitingVehicles = 0;
        int waitingMotorCycles = 0;
        int waitingCars = 0;
        int waitingBuses = 0;

        // Iterate through the queue and attempt to park each car
        System.out.println("Parking queue processing: ");
        for (Vehicle v: parkingQueue) {
            // Using a substr of the vehicle ID as the "license" to avoid spamming console with long UUIDs
            String license = String.valueOf(v.getVehicleId()).substring(0, 8);
            System.out.print(v.getVehicleType() + " #" + license + " has entered the garage");

            // Attempt to park vehicle and print result
            boolean parked = myGarage.parkVehicle(v);
            if(parked) {
                System.out.println(" and parked in slot" + (v.getConsecutiveSpots() > 1 ? "s: " : ": ") + v.getOccupiedSpotNames());
                parkedVehicles++;
            } else {
                System.out.println(" and is waiting in the queue.");
                waitingVehicles++;
                switch (v.getVehicleType()) {
                    case BUS:
                        waitingBuses++;
                        break;
                    case CAR:
                        waitingCars++;
                        break;
                    case MOTORCYCLE:
                    default:
                        waitingMotorCycles++;
                        break;
                }
            }
        }

        // Remainder is various print statements. These are just to give some sort of visual to what is happening.
        // Print final output to console to check the layout
        System.out.println("\nFinal garage status (O = Open, X = Occupied): ");
        myGarage.printParkingStructure();

        // Print out garage dimensions for the user
        System.out.println("Garage has " + numOfFloors + " floors, with " + numOfRows + " rows per floor and " + rowLength + " units per row.");

        // Print some parking success stats for the user
        System.out.println(parkedVehicles + " of " + queueLength + " vehicles were successfully parked! \n");
        if (waitingVehicles > 0) {
            System.out.println((waitingVehicles + " are still waiting in the queue."));
            if(waitingMotorCycles > 0)
                System.out.print((waitingMotorCycles + " of them are Motorcycles. "));
            if(waitingCars > 0)
                System.out.print((waitingCars + " of them are Cars. "));
            if(waitingBuses > 0)
                System.out.print((waitingBuses + " of them are Buses. "));
            System.out.println();
        }
    }
}
