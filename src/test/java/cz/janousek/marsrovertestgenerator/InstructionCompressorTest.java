package cz.janousek.marsrovertestgenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionCompressorTest {

	@BeforeEach
	public void beforeEach() {
		Settings.turnDuringBackwardMove = true;
	}

	@Test
	void compressForwardInstructionsToSouthWithoutTurningTest() {
		String instructions = "FFF";
		Direction start = Direction.S;
		InstructionCompressor compressor = new InstructionCompressor(start, instructions);
		String result = compressor.compress().toString();

		String expected = "[S, S, S]";
		assertEquals(expected, result, "Compressed instructions should be " + expected);
	}

	@Test
	void compressForwardInstructionsToEastWithoutTurningTest() {
		String instructions = "FFF";
		Direction start = Direction.E;
		InstructionCompressor compressor = new InstructionCompressor(start, instructions);
		String result = compressor.compress().toString();

		String expected = "[E, E, E]";
		assertEquals(expected, result, "Compressed instructions should be " + expected);
	}

	@Test
	void compressTurningInstructionsWithoutMoveTest() {
		String instructions = "RLRLLRR";
		Direction start = Direction.E;
		InstructionCompressor compressor = new InstructionCompressor(start, instructions);
		String result = compressor.compress().toString();

		String expected = "[]";
		assertEquals(expected, result, "Compressed instructions should be " + expected);
	}

	@Test
	void compressLongInstructionsFromNorthTest() {
		String instructions = "FRLFRLLFRRFFBRF";
		Direction start = Direction.S;
		InstructionCompressor compressor = new InstructionCompressor(start, instructions);
		String result = compressor.compress().toString();

		String expected = "[S, S, E, W, W, E, S]";
		assertEquals(expected, result, "Compressed instructions should be " + expected);
	}

	@Test
	void compressLongInstructionsFromNorthTestWithoutTurningDuringBackwardMoveTest() {
		Settings.turnDuringBackwardMove = false;
		String instructions = "FRLFRLLFRRFFBRF";
		Direction start = Direction.S;
		InstructionCompressor compressor = new InstructionCompressor(start, instructions);
		String result = compressor.compress().toString();

		String expected = "[S, S, E, W, W, E, N]";
		assertEquals(expected, result, "Compressed instructions should be " + expected);
	}
}