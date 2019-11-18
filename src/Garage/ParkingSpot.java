package Garage;

import java.util.Collections;
import java.util.UUID;

public class ParkingSpot {

    public enum SpotType {
        SMALL,
        COMPACT,
        LARGE
    }

    private SpotType spotType;
    private boolean isOccupied;
    private UUID parentRow;

    ParkingSpot(UUID parentRow, int spotLength) {
        // When we're checking available slots we may need an association with the parent row to check adjacent spots
        this.parentRow = parentRow;

        // You could match the length to type with SpotType.values()[spotLength-1] but doing so creates a
        // new array object each time which seems excessive. We'll go with a hardcoded switch for this exercise.
        switch (spotLength) {
            case 1:
                this.spotType = SpotType.SMALL;
                break;
            case 2:
                this.spotType = SpotType.COMPACT;
                break;
            case 3:
            default:
                this.spotType = SpotType.LARGE;
                break;
        }

        this.isOccupied = false;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public UUID getParentRow() {
        return parentRow;
    }

    public boolean getOccupyStatus() {
        return isOccupied;
    }

    public void setOccupyStatus(boolean status) {
        this.isOccupied = status;
    }

    void printSpot() {
        String spotIndicator = isOccupied ? "X" : "O";
        switch (spotType) {
            case SMALL:
                System.out.print("[" + String.join("", Collections.nCopies(1, spotIndicator)) + "]");
                break;
            case COMPACT:
                System.out.print("[" + String.join("", Collections.nCopies(2, spotIndicator)) + "]");
                break;
            case LARGE:
            default:
                System.out.print("[" + String.join("", Collections.nCopies(3, spotIndicator)) + "]");
                break;
        }
    }

}
