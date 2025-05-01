package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import main.*;

public class MainTest {

    // This is a non-complete version of the tests in autolab, for local testing

    public void validateTour(HashMap<Vector2D, Integer> tour, int x, int y, int size) {
        Vector2D start = new Vector2D(x, y);
        assertEquals("Incomplete tour", size * size, tour.size());
        assertTrue("Tour does not contain start position", tour.containsKey(start));
        assertEquals("Tour does not start at the correct position", 0, tour.get(start).intValue());

        HashMap<Integer, Vector2D> reverse = new HashMap<>();
        tour.forEach((key, value) -> reverse.put(value, key));
        assertEquals("Steps are not unique", size * size, reverse.size());

        for (int i = 0; i < size * size - 1; i++) {
            Vector2D from = reverse.get(i);
            Vector2D to = reverse.get(i + 1);
            assertNotNull(from);
            assertNotNull(to);
            validateMove(from, to);
            validatePosition(to, size);
        }
    }

    private void validateMove(Vector2D from, Vector2D to) {
        int dx = Math.abs(from.getX() - to.getX());
        int dy = Math.abs(from.getY() - to.getY());
        assertTrue("Invalid move", dx == 2 && dy == 1 || dx == 1 && dy == 2);
    }

    private void validatePosition(Vector2D pos, int size) {
        assertTrue(pos.getX() >= 0 && pos.getX() < size && pos.getY() >= 0 && pos.getY() < size);
    }

    @Test
    public void testSmall() {
        int size = 5;
        int x = 0;
        int y = 0;
        HashMap<Vector2D, Integer> tour = Solver.solve(size, x, y);
		validateTour(tour, x, y, size);
        
        x = 1;
        y = 1;
        tour = Solver.solve(size, x, y);
		validateTour(tour, x, y, size);

        x = 4;
        y = 4;
        tour = Solver.solve(size, x, y);
		validateTour(tour, x, y, size);

        x = 3;
        y = 1;
        tour = Solver.solve(size, x, y);
		validateTour(tour, x, y, size);

        x = 0;
        y = 4;
        tour = Solver.solve(size, x, y);
		validateTour(tour, x, y, size);
    }

    @Test
    public void testMedium() {
        int size = 6;
        int x = 5;
        int y = 0;
        HashMap<Vector2D, Integer> tour = Solver.solve(size, x, y);
        validateTour(tour, x, y, size);
    }

}
