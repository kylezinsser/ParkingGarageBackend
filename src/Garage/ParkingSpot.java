package Garage;

import java.util.Collections;
import java.util.UUID;

// This could be altered to either an interface or an abstract class but it's simple enough I decided not to split it
public class ParkingSpot {
    // Enum for the types of spots
    public enum SpotType {
        SMALL,
        COMPACT,
        LARGE
    }

    private SpotType spotType;
    private boolean isOccupied;
    private UUID parentRow;
    private int spotIndex;

    // Constructor just initializes private variables using passed values
    ParkingSpot(UUID parentRow, int spotLength, int spotIndex) {
        // When we're checking available slots we may need an association with the parent row to check adjacent spots
        this.parentRow = parentRow;
        this.spotIndex = spotIndex;

        // You could match the length to type with SpotType.values()[spotLength-1] but doing so creates a
        // new array object each time which seems excessive. We'll go with a hardcoded switch for this exercise.
        switch (spotLength) {
            case 1:
                this.spotType = SpotType.SMALL;
                break;
            case 2:
                this.spotType = SpotType.COMPACT;
                break;
            case 3: // Fallthrough to default since we shouldn't get any other value
            default:
                this.spotType = SpotType.LARGE;
                break;
        }
        // Every new spot starts off as unoccupied
        this.isOccupied = false;
    }

    // Print output isn't pretty but gives a decent visual of what's going on behind the scenes
    void printSpot() {
        String spotIndicator = isOccupied ? "X" : "O";
        switch (spotType) {
            case SMALL:
                System.out.print("[" + String.join("", Collections.nCopies(1, spotIndicator)) + "]");
                break;
            case COMPACT:
                System.out.print("[" + String.join("", Collections.nCopies(2, spotIndicator)) + "]");
                break;
            case LARGE: // Fallthrough to default since we shouldn't get any other value
            default:
                System.out.print("[" + String.join("", Collections.nCopies(3, spotIndicator)) + "]");
                break;
        }
    }

    // Lookup name is for verifying that buses are parked in the same row and in consecutive spots
    public String getSpotLookup() {
        // TODO: make lookup name more readable
        return String.valueOf(this.parentRow).substring(0, 4) + "_slot#" + this.spotIndex;
    }

    // Basic getters and setters follow
    public SpotType getSpotType() {
        return spotType;
    }

    public UUID getParentRow() {
        return parentRow;
    }

    boolean getOccupyStatus() {
        return isOccupied;
    }

    public void setOccupyStatus(boolean status) {
        this.isOccupied = status;
    }
}
