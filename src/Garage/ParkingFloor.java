package Garage;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    public List<ParkingRow> rows;
    private final int numOfRows;

    public ParkingFloor(int numOfRows, int rowLength) {
        this.numOfRows = numOfRows;
        this.rows = generateRows(numOfRows, rowLength);
    }

    private List<ParkingRow> generateRows(int numOfRows, int rowLength) {
        List<ParkingRow> rows = new ArrayList<ParkingRow>();
        for(int i = 0; i < numOfRows; i++) {
            rows.add(new ParkingRow(rowLength));
        }
        return rows;
    }
}
