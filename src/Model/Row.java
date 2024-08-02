package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for a row of hexes
 * Number of hexes is specified by the length (i.e. 3 for 3x3, stacked over each other)
 * Prints status of contained hexes in order with toString
 */
public class Row {

    private final int length;
    private final int width;
    private List<Hex> hexes;

    /**
     * Constructor that accepts a list of Hexes
     * @param length of the row
     * @param hexes that fill the row. Must match the length of the row if nonempty
     * @throws IllegalArgumentException List<Hex> size doesn't match the length of the row
     */
    public Row(int length, List<Hex> hexes) {
        if (!hexes.isEmpty() && hexes.size() != length) {
            throw new IllegalArgumentException("Hexes fail to match row length");
        }
        this.length = length;
        this.width = 1;
        this.hexes = hexes;

    }

    /**
     * Constructor with variable length
     * Autogenerates blank hexes for each row spot
     * @param length
     */
    public Row(int length) {
        this(length, new ArrayList<>());
        for (int i = 0; i < length; i++) {
            hexes.add(new Hex());
        }
    }

    // default row size
    public Row() {
        this(3);
    }

    /**
     * Method to change the state of a contained hex
     * Hexes are numbered 0 through length - 1 with the leftmost being 0
     * Sets the specified hex's state to that specified in the parameters
     *
     * @param spot of the hex to change
     * @param state to switch the hex to
     * @return whether the change was successful
     */
    public Boolean setHex(int spot, String state) {
        if (spot >= 0 && spot < length) {
            state = state.toLowerCase();
            if (state.equals("x") || state.equals("o") || state.equals("-")) {
                hexes.get(spot).setState(state);
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the status of each hex in the row, in order
     * @return status of each hex
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Hex hex : hexes) {
            sb.append(hex.getState());
        }
        return sb.toString();
    }
}
