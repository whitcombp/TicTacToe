package Model;

import java.util.Objects;

/**
 * Individual hex object
 * Has 3 states to show game progression:
 *  Blank (default) X and O
 * Prints status with toString
 */
public class Hex {

    final int length;
    final int width;

    private String state;

    public Hex() {
        length = 1;
        width = 1;
        state = "-";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hex hex = (Hex) o;
        return length == hex.length && width == hex.width && Objects.equals(state, hex.state);
    }

    /**
     * prints state of the hex
     * One space of padding on each side
     * @return state of hex
     */
    @Override
    public String toString(){
        return " " +
                getState() +
                " ";
    }
}
