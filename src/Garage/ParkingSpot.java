package Garage;

public class ParkingSpot {

    public enum SpotType {
        SMALL,
        COMPACT,
        LARGE
    }

    private SpotType spotType;

    ParkingSpot(int spotLength) {
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
    }

    public SpotType getSpotType() {
        return spotType;
    }

}
