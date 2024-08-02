import Model.Grid;

import java.util.Scanner;

/**
 * Driver of the program
 * Console input to get mode (3x3) (4x4) (3x3 with each hex having 3x3)
 * Generates default grids
 * Gets user input for moves / actions
 * Prints result
 *  Option for pdf/text document with each
 */

public class Driver {

    private static int length;
    private static int height;
    private static Grid grid;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter the length of the playing grid");
        length = in.nextInt();
        System.out.println("Enter the width of the playing grid");
        height = in.nextInt();

        grid = new Grid(length, height);

        String input = "";
        while(!input.equals("escape")) {
            while(!input.equals("restart")) {
                System.out.println("The grid currently looks like:");
                System.out.print(grid);
                System.out.println("Hexes are numbered as follows:");
                System.out.println(generateNumberedGrid());
                System.out.println("Enter the location of the hex to change:");
                int spot = in.nextInt();

                System.out.println("Enter (x), (o), or (-) to change the hex");
                String state = in.next();

                if (!grid.setHex(spot, state)) {
                    System.out.println("Error. Try again");
                } else {
                    System.out.print(grid);
                }
                System.out.println("Type (restart) to restart, (escape) to escape, " +
                        "or anything else to continue");
                input = in.next();
                if (input.equals("escape")) {
                    break;
                }
            }
        }

    }

    private static String generateNumberedGrid() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int j = 0; j < height; j++) {
            sb.append(" ");
            for (int i = 0; i < length; i++) {
                sb.append(count);
                count++;
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
