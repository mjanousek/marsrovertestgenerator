package cz.janousek.marsrovertestgenerator;

import java.util.List;

public class Solver {
	public Position computeFinalPositions(Configuration config) {
		InstructionCompressor c = new InstructionCompressor(config.getStartDirection(), config.getInstructions());
		List<Direction> compressedInstructions = c.compress();
		Position oldPosition = config.getStartPosition();
		for (Direction d : compressedInstructions) {
			Position newPosition = oldPosition.getNeighbour(d);
			if (isAccessiblePosition(newPosition, config.getSize(), config.getStones())) {
				oldPosition = newPosition;
			}
		}
		return oldPosition;
	}

	boolean isAccessiblePosition(Position p, int size, List<Position> stones) {
		return isInsideTheMap(p, size) && !stones.contains(p);
	}

	private boolean isInsideTheMap(Position p, int mapSize) {
		return p.x >= 0 && p.x < mapSize && p.y >= 0 && p.y < mapSize;
	}
}
