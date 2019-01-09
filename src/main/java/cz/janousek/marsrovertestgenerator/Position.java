package cz.janousek.marsrovertestgenerator;

import java.util.Objects;

public class Position {
	public final int x;
	public final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position getNeighbour(Direction direction) {
		switch (direction) {
			case S:
				return new Position(x + 1, y);
			case N:
				return new Position(x - 1, y);
			case E:
				return new Position(x, y + 1);
			case W:
				return new Position(x, y - 1);
			default:
				return this;
		}
	}

	@Override
	public String toString() {
		return String.format("[%d,%d]", x, y);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return x == position.x &&
				y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
