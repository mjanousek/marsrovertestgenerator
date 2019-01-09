package cz.janousek.marsrovertestgenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomPositionGenerator implements PositionGenerator {

	private final Random RANDOM = new Random();

	@Override
	public Position generate(int max) {
		return new Position(RANDOM.nextInt(max), RANDOM.nextInt(max));
	}

	@Override
	public List<Position> generateList(int count, int max, Position excludePosition) {
		List<Position> positions = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			Position p = generate(max);
			if (p.equals(excludePosition)) {
				i--;
				continue;
			}
			positions.add(p);
		}
		return positions;
	}
}
