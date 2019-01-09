package cz.janousek.marsrovertestgenerator;

import java.util.List;

public class Configuration {
	private final int size;
	private final Position startPosition;
	private final Direction startDirection;
	private final String instructions;
	private final List<Position> stones;

	public Configuration(int size, Position startPosition, Direction startDirection, String instructions, List<Position> stones) {
		this.size = size;
		this.startPosition = startPosition;
		this.startDirection = startDirection;
		this.instructions = instructions;
		this.stones = stones;
	}

	public int getSize() {
		return size;
	}

	public Position getStartPosition() {
		return startPosition;
	}

	public Direction getStartDirection() {
		return startDirection;
	}

	public String getInstructions() {
		return instructions;
	}

	public List<Position> getStones() {
		return stones;
	}
}
