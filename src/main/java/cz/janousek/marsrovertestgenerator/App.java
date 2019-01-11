package cz.janousek.marsrovertestgenerator;

public class App {

	public static void main(String[] args) {
		//AssignmentInputPrinter printer = new AssignmentInputPrinter();
		AssignmentInputPrinter printer = new TestMethodPrinter(true);
		//printer.setStrategy(new FilePrinterStrategyImpl(System.getProperty("user.dir") + "\\out\\files\\true\\"));
		printer.setStrategy(new StdoutPrinterStrategyImpl());

		// Test that moving forward to each direction works
		singleStepTest(printer);
		// Turning the rover should not move the rover from the current position
		turningDoesNotMoveRover(printer);
		// Test multiple forward moves in each direction
		straightMovementAcrossMap(printer);
		// Test that rover cannot step on an inaccessible field
		cannotMoveThroughStone(printer);
		// Test that rover cannot move outside the map
		cannotMoveOutsideTheMap(printer);
		// Test more complicated movement - move rover around the map
		circleAroundMap(printer);

		InstructionGenerator instructionGenerator = new RandomInstructionGenerator();
		PositionGenerator positionGenerator = new RandomPositionGenerator();
		Solver solver = new Solver();
		Generator g = new Generator(positionGenerator, instructionGenerator, solver);
		g.setPrinter(printer);

		g.generateCases(3, 5, 1);
		g.generateCases(5, 10, 3);
		g.generateCases(5, 10, 3);
		g.generateCases(7, 20, 4);
		g.generateCases(10, 30, 7);
		g.generateCases(10, 30, 7);
		g.generateCases(15, 25, 10);
		g.generateCases(15, 25, 10);
		g.generateCases(15, 25, 10);

		printer = new TestMethodPrinter(false);
		//printer.setStrategy(new FilePrinterStrategyImpl(System.getProperty("user.dir") + "\\out\\files\\false\\"));
		printer.setStrategy(new StdoutPrinterStrategyImpl());

		// Move rover from finish position - test that program does not return TRUE all the time
		singleStepReturnsFalseTest(printer);
	}

	private static void singleStepTest(AssignmentInputPrinter printer) {
		for(Direction direction : Direction.values()) {
			CaseBuilder factory = new CaseBuilder();
			factory
					.setSize(5)
					.setStartPosition(2, 2)
					.setStartDirection(direction)
					.getInstructionFactory()
					.forward();

			printer.print(factory.build());
		}
	}

	private static void straightMovementAcrossMap(AssignmentInputPrinter printer) {
		for(Direction direction : Direction.values()) {
			CaseBuilder factory = new CaseBuilder();

			factory
					.setSize(5)
					.setStartDirection(direction)
					.getInstructionFactory()
					.forward(4);

			switch (direction) {
				case N:
					factory.setStartPosition(4, 2);
					break;
				case S:
					factory.setStartPosition(0, 2);
					break;
				case E:
					factory.setStartPosition(2, 0);
					break;
				case W:
					factory.setStartPosition(2, 4);
					break;
			}

			printer.print(factory.build());
		}
	}

	private static void cannotMoveThroughStone(AssignmentInputPrinter printer) {
		for(Direction direction : Direction.values()) {
			CaseBuilder factory = new CaseBuilder();
			factory
					.setSize(5)
					.setStartPosition(2, 2)
					.setStartDirection(direction)
					.getInstructionFactory()
					.forward(3);

			switch (direction) {
				case N:
					factory.addStone(1, 2);
					break;
				case S:
					factory.addStone(3, 2);
					break;
				case E:
					factory.addStone(2, 3);
					break;
				case W:
					factory.addStone(2, 1);
					break;
			}

			printer.print(factory.build());
		}
	}

	private static void cannotMoveOutsideTheMap(AssignmentInputPrinter printer) {
		for(Direction direction : Direction.values()) {
			CaseBuilder factory = new CaseBuilder();
			factory
					.setSize(1)
					.setStartPosition(0, 0)
					.setStartDirection(direction)
					.getInstructionFactory()
					.forward();

			printer.print(factory.build());
		}
	}

	private static void turningDoesNotMoveRover(AssignmentInputPrinter printer) {
		CaseBuilder factory = new CaseBuilder();
		factory
				.setSize(5)
				.setStartPosition(2, 2)
				.setStartDirection(Direction.W)
				.getInstructionFactory()
				.left(4)
				.right(2);

		printer.print(factory.build());
	}

	private static void circleAroundMap(AssignmentInputPrinter printer) {
		CaseBuilder factory = new CaseBuilder();
		factory
				.setSize(5)
				.setStartPosition(4, 4)
				.setStartDirection(Direction.N)
				.getInstructionFactory()
				.forward(4)
				.left()
				.forward(4)
				.left()
				.forward(4)
				.left()
				.forward(4);

		printer.print(factory.build());
	}

	private static void singleStepReturnsFalseTest(AssignmentInputPrinter printer) {
		for(Direction direction : Direction.values()) {
			CaseBuilder factory = new CaseBuilder();
			factory
					.setSize(5)
					.setStartPosition(2, 2)
					.setStartDirection(direction)
					.setEndPosition(2, 2)
					.getInstructionFactory()
					.forward();

			printer.print(factory.build());
		}
	}
}
