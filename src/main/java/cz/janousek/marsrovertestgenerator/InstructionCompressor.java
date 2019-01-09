package cz.janousek.marsrovertestgenerator;

import java.util.LinkedList;
import java.util.List;

public class InstructionCompressor {

	private final String instructions;
	private Direction actualDirection;
	private int turnRightTimes;
	private final List<Direction> output;

	public InstructionCompressor(Direction start, String instructions) {
		this.actualDirection = start;
		this.instructions = instructions;
		this.turnRightTimes = 0;
		this.output = new LinkedList<>();
	}

	public List<Direction> compress() {
		for (int i = 0; i < instructions.length(); i++){
			char c = instructions.charAt(i);
			processInstruction(c);
		}
		return output;
	}

	private void processInstruction(char c) {
		switch (c) {
			case 'F':
				actualDirection = Direction.turnRight(actualDirection, turnRightTimes);
				turnRightTimes = 0;
				output.add(actualDirection);
				break;
			case 'B':
				actualDirection = Direction.turnRight(actualDirection, turnRightTimes + 2);
				turnRightTimes = Settings.turnDuringBackwardMove ? 0 : 2;
				output.add(actualDirection);
				break;
			case 'L':
				turnRightTimes -= 1;
				break;
			case 'R':
				turnRightTimes += 1;
				break;
		}
	}
}
