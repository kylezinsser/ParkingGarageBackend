package Garage;

import java.util.ArrayList;
import java.util.List;

public class ParkingRow {
    public List<ParkingSpot> spots;
    private final int rowLength;

    public ParkingRow(int rowLength) {
        this.rowLength = rowLength;
        this.spots = generateSpots(rowLength);
    }

    private List<ParkingSpot> generateSpots(int rowLength) {
        List<ParkingSpot> rows = new ArrayList<ParkingSpot>();
        for(int i = 0; i < rowLength; i++) {
            rows.add(new ParkingSpot());
        }
        return rows;
    }
}
