package cz.janousek.marsrovertestgenerator;

import java.util.List;

public class Generator {

	private final PositionGenerator positionGenerator;
	private final InstructionGenerator instructionGenerator;
	private final Solver solver;
	private AssignmentInputPrinter printer;

	public Generator(PositionGenerator positionGenerator, InstructionGenerator instructionGenerator, Solver solver) {
		this.positionGenerator = positionGenerator;
		this.instructionGenerator = instructionGenerator;
		this.solver = solver;
	}

	public void setPrinter(AssignmentInputPrinter printer) {
		this.printer = printer;
	}

	public void generateCases(int mapSize, int instructionLength, int numberOfStones) {
		if (printer == null) {
			throw new RuntimeException("Printer not set");
		}

		// TODO move to different place
		Case c = generateCase(true, mapSize, instructionLength, numberOfStones);
		printer.print(c);
	}

	private Case generateCase(boolean programResult, int mapSize, int instructionLength, int numberOfStones) {
		Position startPosition = positionGenerator.generate(mapSize);
		String instructions = instructionGenerator.generate(instructionLength);
		List<Position> stones = positionGenerator.generateList(numberOfStones, mapSize, startPosition);
		Direction startDirection = Direction.randomDirection();
		Configuration configuration = new Configuration(mapSize, startPosition, startDirection, instructions, stones);
		Position endPosition = solver.computeFinalPositions(configuration);
		Case c = new Case(configuration, endPosition);
		return c;
	}

	public void generate() {
		// Generate map size
		// Generate start position
		// Generate start direction
		// Generate instructions sequence
		// Generate stones
		// Compute final positions
		// Print configuration
	}
}
