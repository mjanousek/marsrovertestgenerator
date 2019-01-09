package cz.janousek.marsrovertestgenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {
	N(0),
	E(1),
	S(2),
	W(3);

	private final int value;

	private static final List<Direction> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	Direction(int value) {
		this.value = value;
	}

	public static Direction turnRight(Direction oldDirection, int times) {
		int newValue = getNewValue(oldDirection, times);

		for (Direction newDirection : Direction.values()) {
			if (newDirection.value == newValue) {
				return newDirection;
			}
		}
		throw new RuntimeException("New direction could not be deduced.");
	}

	private static int getNewValue(Direction oldDirection, int times) {
		int newValue = (oldDirection.value + times) % Direction.values().length;
		if (newValue < 0) {
			newValue += Direction.values().length;
		}
		return newValue;
	}

	public static Direction randomDirection() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
