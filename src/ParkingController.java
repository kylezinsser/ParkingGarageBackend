import Garage.ParkingGarage;
import Garage.ParkingSpot;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// This class will drive the main functionality so that the other classes can stay more discrete
// For example, ParkingGarage doesn't need to know how to park a Vehicle. It only cares about its component classes.
class ParkingController {

    private ParkingGarage garage;

    ParkingController(int numOfFloors, int numOfRows, int rowLength) {
        this.garage = new ParkingGarage(numOfFloors, numOfRows, rowLength);
    }

    boolean parkVehicle(Vehicle v) {
        List<ParkingSpot> availableSpots = garage.getAvailableSpots();
        List<ParkingSpot> occupiedSpots = garage.getOccupiedSpots();
        int consecutiveSpots = v.getConsecutiveSpots();

        // Some vehicles need multiple spots, so we'll use an array to keep track of possible candidates
        List<ParkingSpot> potentialSpots = new ArrayList<>();
        // Consecutive spots need to be in the same row, so we'll keep track of the previous row ID
        UUID lastRow = null;

        // Iterate through available spots
        for (ParkingSpot spot : availableSpots) {
            // If current spot isn't in the same row as previous, reset the potentialSpots array
            if (lastRow != null && spot.getParentRow() != lastRow) {
                potentialSpots = new ArrayList<>();
            }
            lastRow = spot.getParentRow();

            // If current spot type is compatible with the vehicle spot types, we should consider it
            if (v.getCompatibleSpots().contains(spot.getSpotType())) {
                potentialSpots.add(spot);

                // Check if we have enough consecutive spots to park
                if (potentialSpots.size() == consecutiveSpots) {
                    // For each spot candidate we have to update spot attributes
                    for (ParkingSpot s : potentialSpots) {
                        // Set spot to occupied
                        s.setOccupyStatus(true);

                        // Update the garage's available and occupied spots
                        availableSpots.remove(s);
                        occupiedSpots.add(s);
                    }

                    // Use the ParkingGarage setters to update the status lists
                    garage.setAvailableSpots(availableSpots);
                    garage.setOccupiedSpots(occupiedSpots);

                    // Also update the vehicle spot list
                    v.setOccupiedSpots(potentialSpots);

                    return true;
                }
            } else {
                // If an incompatible spot type is encountered we must reset the spot candidates
                potentialSpots = new ArrayList<>();
            }
        }
        // No available spots found
        return false;
    }

    void printParkingStructure() {
        garage.printGarage();
    }
}
