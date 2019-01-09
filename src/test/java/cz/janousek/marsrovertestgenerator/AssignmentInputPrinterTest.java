package cz.janousek.marsrovertestgenerator;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentInputPrinterTest {

	@Test
	void generateOutputTest() {
		int size = 5;
		Position startPostion = new Position(1,0);
		Direction startDirection = Direction.N;
		String instructions = "RRFLFRFF";
		List<Position> stones = new LinkedList<>();
		stones.add(new Position(2,0));
		stones.add(new Position(1,3));
		stones.add(new Position(2,3));
		stones.add(new Position(4,3));
		Configuration config = new Configuration(size, startPostion, startDirection, instructions, stones);
		Position finalPosition = new Position(4,0);
		AssignmentInputPrinter printer = new AssignmentInputPrinter();
		String result = printer.generateOutput(config, finalPosition);

		String expected =
				"1,0\n" +
				"\n" +
				"N\n" +
				"\n" +
				"5\n" +
				"\n" +
				"2,0;1,3;2,3;4,3\n" +
				"\n" +
				"4,0\n" +
				"\n" +
				"RRFLFRFF";
		assertEquals(expected, result, "Output should be the same.");


	}
}