package Garage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingRow {
    // Each row is the same length but can have a different mix of parking spot types
    // For simplicity we will have small=1, compact=2, and large=3 units in length
    private final int rowLength;
    public List<ParkingSpot> spots;

    public ParkingRow(int rowLength) {
        this.rowLength = rowLength;
        this.spots = generateSpots(rowLength);
    }

    private List<ParkingSpot> generateSpots(int rowLength) {
        List<ParkingSpot> spots = new ArrayList<ParkingSpot>();
//        for(int i = 0; i < rowLength; i++) {
//            rows.add(new ParkingSpot());
//        }

        Random random = new Random();
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

            spots.add(new ParkingSpot(nextSlotLength));
            rowLength -= nextSlotLength;
        }

        int i = 0;
        for(ParkingSpot spot : spots) {
            System.out.print(spot.getSpotType());
            if(i++ == spots.size() - 1) {
                System.out.println("");
            } else {
                System.out.print(" - ");
            }
        }
        System.out.println("----------------------------------------------");

        return spots;
    }
}
