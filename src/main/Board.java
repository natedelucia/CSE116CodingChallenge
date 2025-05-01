package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * You may use this board class if you want. It has some functions that may help you to program the solver, but it is
 * likely not very fast
 */
public class Board {

	/**
	 * List of all 8 relative moves that a knight can take
	 */
	public static ArrayList<Vector2D> directions = new ArrayList<>(
			Arrays.asList(new Vector2D(2, 1), new Vector2D(1, 2), new Vector2D(-1, 2), new Vector2D(-2, 1),
					new Vector2D(-2, -1), new Vector2D(-1, -2), new Vector2D(1, -2), new Vector2D(2, -1)));

	private int size;
	private HashMap<Vector2D, Integer> grid = new HashMap<>();

	/**
	 * Create a board, and initalize the grid to an empty HashMap
	 * @param size must be greater than or equal to 5 in order for it to be solvable
	 */
	public Board(int size) {
		this.size = Math.max(5, size); // Board must be at least 5x5
	}

	/**
	 * Access the grid of the board. This grid is N*N, where N is the input size to the Board constructor
	 * It is represented as a map from a particular location <x, y> to it's order in the path. Initially,
	 * it is empty, signifying that nothing has been explored yet
	 * @return the grid
	 */
	public HashMap<Vector2D, Integer> getGrid() {
		return this.grid;
	}

	/**
	 * Checks if a position in within the bounds of the board
	 * @param pos position to consider
	 * @return validity
	 */
	public boolean isValidPos(Vector2D pos) {
		return (pos.getX() >= 0 && pos.getX() < size && pos.getY() >= 0 && pos.getY() < size);
	}

	/**
	 * Gets all of the possible moves from a point, excluding those which are outside the bounds of the board
	 * @param pos position to move from
	 * @return list of all moves from a point
	 */
	public ArrayList<Vector2D> getMoves(Vector2D pos) {
		ArrayList<Vector2D> moves = new ArrayList<>();
		for (Vector2D direction : directions) {
			Vector2D move = new Vector2D(pos.getX() + direction.getX(), pos.getY() + direction.getY());
			if (isValidPos(move)) {
				moves.add(move);
			}
		}
		return moves;
	}

	/**
	 * Nicely print the position of each tile in the tour. If a particular tile is not in the map, it is printed as -1
	 */
	public void printGrid() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.printf("%2d ", grid.getOrDefault(new Vector2D(x, y), -1));
            }
            System.out.println();
        }
    }

}
