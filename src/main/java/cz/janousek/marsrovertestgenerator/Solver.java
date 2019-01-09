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
		if (
				p.x < 0 || p.x >= size ||
						p.y < 0 || p.y >= size ||
						stones.contains(p)
		) {
			return false;
		} else {
			return true;
		}
	}
}
