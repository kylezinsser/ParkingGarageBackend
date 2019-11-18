package Garage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingFloor {
    private List<ParkingRow> rows;
    private final int floorLevel;
    private final int numOfRows;
    private final int rowLength;

    ParkingFloor(int floorLevel, int numOfRows, int rowLength) {
        this.floorLevel = floorLevel;
        this.numOfRows = numOfRows;
        this.rowLength = rowLength;
        this.rows = generateRows(numOfRows, rowLength);
    }

    private List<ParkingRow> generateRows(int numOfRows, int rowLength) {
        List<ParkingRow> rows = new ArrayList<ParkingRow>();
        for(int i = 0; i < numOfRows; i++) {
            rows.add(new ParkingRow(i, rowLength));
        }
        return rows;
    }

    public List<ParkingRow> getRows() {
        return rows;
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    void printFloor() {
        String floorDivider = String.join("", Collections.nCopies(rowLength*2, "="));
        System.out.println(floorDivider + " Start Floor " + floorLevel);
        for (ParkingRow row : rows) {
            row.printRow();
        }
        System.out.println(floorDivider + " End Floor " + floorLevel);
        System.out.println("");
    }
}
