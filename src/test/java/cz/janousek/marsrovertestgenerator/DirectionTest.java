package cz.janousek.marsrovertestgenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

	@Test
	void turnRightNorthWithnoutTurnTest() {
		Direction init = Direction.N;
		Direction result = Direction.turnRight(init, 0);

		Direction expected = Direction.N;
		assertEquals(expected, result, "Direction is different from N");
	}

	@Test
	void turnRightWestWithnoutTurnTest() {
		Direction init = Direction.W;
		Direction result = Direction.turnRight(init, 0);

		Direction expected = Direction.W;
		assertEquals(expected, result, "Direction is different from W");
	}

	@Test
	void turnRightSouthWithnoutTurnTest() {
		Direction init = Direction.S;
		Direction result = Direction.turnRight(init, 0);

		Direction expected = Direction.S;
		assertEquals(expected, result, "Direction is different from S");
	}

	@Test
	void turnRightEastWithnoutTurnTest() {
		Direction init = Direction.E;
		Direction result = Direction.turnRight(init, 0);

		Direction expected = Direction.E;
		assertEquals(expected, result, "Direction is different from E");
	}

	@Test
	void turnRightNorthWithTurnOneTimeTest() {
		Direction init = Direction.N;
		Direction result = Direction.turnRight(init, 1);

		Direction expected = Direction.E;
		assertEquals(expected, result, "Direction is different from E");
	}

	@Test
	void turnRightNorthWithTurnOneTimeReverseTest() {
		Direction init = Direction.N;
		Direction result = Direction.turnRight(init, -1);

		Direction expected = Direction.W;
		assertEquals(expected, result, "Direction is different from W");
	}

	@Test
	void turnRightNorthWithTurnFiveTimesTest() {
		Direction init = Direction.N;
		Direction result = Direction.turnRight(init, 5);

		Direction expected = Direction.E;
		assertEquals(expected, result, "Direction is different from E");
	}

	@Test
	void turnRightNorthWithTurnFiveTimesReverseTest() {
		Direction init = Direction.N;
		Direction result = Direction.turnRight(init, -5);

		Direction expected = Direction.W;
		assertEquals(expected, result, "Direction is different from W");
	}
}