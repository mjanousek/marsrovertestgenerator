package cz.janousek.marsrovertestgenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

	private Solver solver;

	@BeforeEach
	public void beforeEach() {
		this.solver = new Solver();
	}

	@Test
	public void isAccessiblePosition00Test () {
		Position p = new Position(0, 0);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertTrue(result, "Position " + p + " should be accessible.");
	}

	@Test
	public void isAccessiblePosition10Test () {
		Position p = new Position(1, 0);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertTrue(result, "Position " + p + " should be accessible.");
	}

	@Test
	public void isAccessiblePosition01Test () {
		Position p = new Position(0, 1);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertTrue(result, "Position " + p + " should be accessible.");
	}

	@Test
	public void isAccessiblePosition11Test () {
		Position p = new Position(1, 1);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertTrue(result, "Position " + p + " should be accessible.");
	}

	@Test
	public void isInaccessiblePositionNegativeXTest () {
		Position p = new Position(-1, 1);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertFalse(result, "Position " + p + " should be inaccessible.");
	}

	@Test
	public void isInaccessiblePositionNegativeYTest () {
		Position p = new Position(1, -1);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertFalse(result, "Position " + p + " should be inaccessible.");
	}

	@Test
	public void isInaccessiblePositionGreaterXThanSizeTest () {
		Position p = new Position(2, 1);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertFalse(result, "Position " + p + " should be inaccessible.");
	}

	@Test
	public void isInaccessiblePositionGreaterYThanSizeTest () {
		Position p = new Position(1, 2);
		int size = 2;
		List<Position> stones = new LinkedList<>();

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertFalse(result, "Position " + p + " should be inaccessible.");
	}

	@Test
	public void isInaccessiblePositionWithStoneTest () {
		Position p = new Position(1, 0);
		int size = 2;
		List<Position> stones = new LinkedList<>();
		stones.add(p);

		boolean result = solver.isAccessiblePosition(p, size, stones);
		assertFalse(result, "Position " + p + " should be inaccessible.");
	}

	@Test
	void computeFinalPositionOneForwardMoveTest() {
		// Generate map size
		int size = 2;
		// Generate start position
		Position startPostion = new Position(0,0);
		// Generate start direction
		Direction startDirection = Direction.S;
		// Generate instructions sequence
		String instructions = "F";
		// Generate stones
		List<Position> stones = new LinkedList<>();
		Configuration config = new Configuration(size, startPostion, startDirection, instructions, stones);
		// Compute final positions
		Position finalPosition = solver.computeFinalPositions(config);

		Position expectedPosition = new Position(1, 0);
		assertEquals(expectedPosition, finalPosition, "Final position should be " + expectedPosition);
	}

	@Test
	void computeFinalPositionSimpleMoveReturnToTheStartPositionTest() {
		// Generate map size
		int size = 2;
		// Generate start position
		Position startPostion = new Position(0,0);
		// Generate start direction
		Direction startDirection = Direction.S;
		// Generate instructions sequence
		String instructions = "FLRLRRFFRF";
		// Generate stones
		List<Position> stones = new LinkedList<>();
		Configuration config = new Configuration(size, startPostion, startDirection, instructions, stones);
		// Compute final positions
		Position finalPosition = solver.computeFinalPositions(config);

		Position expectedPosition = new Position(0, 0);
		assertEquals(expectedPosition, finalPosition, "Final position should be " + expectedPosition);
	}

	@Test
	void computeFinalPositionSimpleMoveTest() {
		// Generate map size
		int size = 2;
		// Generate start position
		Position startPostion = new Position(0,0);
		// Generate start direction
		Direction startDirection = Direction.S;
		// Generate instructions sequence
		String instructions = "FLRLRLFFRF";
		// Generate stones
		List<Position> stones = new LinkedList<>();
		Configuration config = new Configuration(size, startPostion, startDirection, instructions, stones);
		// Compute final positions
		Position finalPosition = solver.computeFinalPositions(config);

		Position expectedPosition = new Position(1, 1);
		assertEquals(expectedPosition, finalPosition, "Final position should be " + expectedPosition);
	}

	@Test
	void computeFinalPositionSimpleMoveWithStonesTest() {
		// Generate map size
		int size = 2;
		// Generate start position
		Position startPostion = new Position(0,0);
		// Generate start direction
		Direction startDirection = Direction.S;
		// Generate instructions sequence
		String instructions = "FLFF";
		// Generate stones
		List<Position> stones = new LinkedList<>();
		stones.add(new Position(1,0));
		Configuration config = new Configuration(size, startPostion, startDirection, instructions, stones);
		// Compute final positions
		Position finalPosition = solver.computeFinalPositions(config);

		Position expectedPosition = new Position(0, 1);
		assertEquals(expectedPosition, finalPosition, "Final position should be " + expectedPosition);
	}

	@Test
	void computeFinalPositionHomeworkTrueExampleTest() {
		// Generate map size
		int size = 5;
		// Generate start position
		Position startPostion = new Position(1,0);
		// Generate start direction
		Direction startDirection = Direction.N;
		// Generate instructions sequence
		String instructions = "RRFLFRFF";
		// Generate stones
		List<Position> stones = new LinkedList<>();
		stones.add(new Position(3,0));
		stones.add(new Position(1,3));
		stones.add(new Position(4,3));
		stones.add(new Position(1,5));

		Configuration config = new Configuration(size, startPostion, startDirection, instructions, stones);
		// Compute final positions
		Position finalPosition = solver.computeFinalPositions(config);

		Position expectedPosition = new Position(4, 1);
		assertEquals(expectedPosition, finalPosition, "Final position should be " + expectedPosition);
	}

	@Test
	void computeFinalPositionHomeworkFalseExampleTest() {
		// Generate map size
		int size = 5;
		// Generate start position
		Position startPostion = new Position(1,0);
		// Generate start direction
		Direction startDirection = Direction.N;
		// Generate instructions sequence
		String instructions = "RRFLFRFF";
		// Generate stones
		List<Position> stones = new LinkedList<>();
		stones.add(new Position(2,0));
		stones.add(new Position(1,3));
		stones.add(new Position(2,3));
		stones.add(new Position(4,3));

		Configuration config = new Configuration(size, startPostion, startDirection, instructions, stones);
		// Compute final positions
		Position finalPosition = solver.computeFinalPositions(config);

		Position expectedPosition = new Position(3, 1);
		assertEquals(expectedPosition, finalPosition, "Final position should be " + expectedPosition);
	}
}