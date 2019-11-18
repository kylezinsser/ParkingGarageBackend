package Garage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingFloor {
    // List to contain row objects
    private List<ParkingRow> rows;
    private final int floorLevel;
    private final int numOfRows;
    private final int rowLength;

    // Constructor just initializes private variables using passed values
    ParkingFloor(int floorLevel, int numOfRows, int rowLength) {
        this.floorLevel = floorLevel;
        this.numOfRows = numOfRows;
        this.rowLength = rowLength;
        this.rows = generateRows(numOfRows, rowLength);
    }

    // We need to create a set of rows for each new ParkingFloor object
    private List<ParkingRow> generateRows(int numOfRows, int rowLength) {
        List<ParkingRow> rows = new ArrayList<>();
        for(int i = 0; i < numOfRows; i++) {
            rows.add(new ParkingRow(i, rowLength));
        }
        return rows;
    }

    // Print commands are passed on to each row
    void printFloor() {
        String floorDivider = String.join("", Collections.nCopies(rowLength*2, "="));
        System.out.println(floorDivider + " Start Floor " + floorLevel);
        for (ParkingRow row : rows) {
            row.printRow();
        }
        System.out.println(floorDivider + " End Floor " + floorLevel);
        System.out.println("");
    }

    // Basic getters follow
    List<ParkingRow> getRows() {
        return rows;
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    public int getNumOfRows() {
        return numOfRows;
    }
}
