package cz.janousek.marsrovertestgenerator;

import java.util.List;

public interface PositionGenerator {
	Position generate(int mapSize);
	List<Position> generateList(int numberOfPositions, int mapSize, Position excludePosition);
}
