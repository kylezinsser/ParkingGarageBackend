package Garage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

// Each row is the same length but can have a different mix of parking spot types
// For simplicity we will have small=1, compact=2, and large=3 units in length
public class ParkingRow {
    private final int rowLength;
    private final int rowNumber;
    private List<ParkingSpot> spots;
    private UUID rowId;

    // Constructor just initializes private variables using passed values
    ParkingRow(int rowNumber, int rowLength) {
        this.rowId = UUID.randomUUID();
        this.rowNumber = rowNumber;
        this.rowLength = rowLength;
        this.spots = generateSpots(rowLength);
    }

    // We need to create a set of spots for each new ParkingSpot object
    private List<ParkingSpot> generateSpots(int rowLength) {
        List<ParkingSpot> spots = new ArrayList<>();

        Random random = new Random();
        int spotIndex = 0;
        while(rowLength > 0) {
            // Get a random length between 1-3 (inclusive)
            int nextSlotLength = random.nextInt(3) + 1;

            // Note that by arranging randomly there is a very low likelihood of being able to fit buses
            // We'll try to nudge the odds a bit higher by converting half the small slots to large ones
            if (nextSlotLength == 1) {
                nextSlotLength = nextSlotLength + (2 * random.nextInt(2));
            }

            // Make sure we don't exceed the remaining row length by taking the min of both values
            nextSlotLength = Math.min(nextSlotLength, rowLength);

            // Instantiate new ParkingSpot object and add it to the list
            spots.add(new ParkingSpot(rowId, nextSlotLength, spotIndex));
            rowLength -= nextSlotLength;
            spotIndex++;
        }
        return spots;
    }

    // Print commands are passed on to each spot
    void printRow() {
        for (ParkingSpot spot : spots) {
            spot.printSpot();
        }
        System.out.println();
    }

    // Basic getters follow
    List<ParkingSpot> getSpots() {
        return spots;
    }

    public int getRowLength() {
        return rowLength;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
