package cz.janousek.marsrovertestgenerator;

import java.util.ArrayList;
import java.util.List;

class CaseBuilder {

    private int mapSize = 5;
    private Position startPosition;
    private Direction startDirection;
    private Position endPosition;
    private List<Position> stones = new ArrayList<>();
    private final InstructionFactory iFactory = new InstructionFactory();

    public CaseBuilder setSize(int size) {
        mapSize = size;

        return this;
    }

    public CaseBuilder setStartPosition(int x, int y) {
        startPosition = new Position(x, y);

        return this;
    }

    public CaseBuilder setStartDirection(Direction direction) {
        startDirection = direction;

        return this;
    }

    public CaseBuilder setEndPosition(int x, int y) {
        endPosition = new Position(x, y);

        return this;
    }


    public CaseBuilder addStone(int x, int y) {
        stones.add(new Position(x, y));

        return this;
    }

    public InstructionFactory getInstructionFactory() {
        return iFactory;
    }

    public Case build() {
        if (startPosition == null) {
            throw new RuntimeException("Start position was not set");
        }

        if (startDirection == null) {
            throw new RuntimeException("Start direction was not set");
        }

        Solver solver = new Solver();
        Configuration configuration = new Configuration(mapSize, startPosition, startDirection, iFactory.getResult(), stones);

        Position _endPosition = endPosition;
        if (_endPosition == null) {
            _endPosition = solver.computeFinalPositions(configuration);
        }

        return new Case(configuration, _endPosition);
    }
}
