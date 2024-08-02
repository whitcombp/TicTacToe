package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Container class for all rows that make up the game grid
 */
public class Grid {

    private final int length;
    private final int height;
    private final int size;
    private List<Row> rows;

    public Grid(int length, int height, List<Row> rows) {
        this.length = length;
        this.height = height;
        size = length * height;
        this.rows = rows;
    }

    public Grid (int length, int height) {
        this(length, height, new ArrayList<>());
        for (int i = 0; i < height; i++) {
            rows.add(new Row(length)); // add default (blank) rows
        }
    }

    public Grid() {
        this(3, 3, new ArrayList<>());
        for (int i = 0; i < height; i++) {
            rows.add(new Row(length)); // add default (blank) rows
        }
    }

    /**
     * Method to find the hex within the grid, or return false if it's not there.
     * Hexes are numbered 0 through size, with the top left being 0 and progressing
     * Left to right.
     *
     * @param spot of the hex to change the state of
     * @param state to be changed to
     * @return whether the change was successful or not
     */
    public Boolean setHex(int spot, String state) {
        if (spot >= 0 && spot < size) {
            state = state.toLowerCase();
            if (state.equals("x") || state.equals("o") || state.equals("-")) {
                int row = spot / length;
                int position = spot - row * length;
                rows.get(row).setHex(position, state);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Row row : rows) {
            sb.append(row.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
