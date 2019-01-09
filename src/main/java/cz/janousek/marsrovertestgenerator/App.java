package cz.janousek.marsrovertestgenerator;

public class App {

	public static void main(String[] args) {
		AssignmentInputPrinter printer = new AssignmentInputPrinter();
		printer.setStrategy(new FilePrinterStrategyImpl(System.getProperty("user.dir") + "\\out\\files\\"));

		singleStepTest(printer);
		turningDoesNotMoveRover(printer);
		straightMovementAcrossMap(printer);
		cannotMoveThroughStone(printer);
		cannotMoveOutsideTheMap(printer);
		circleAroundMap(printer);

		InstructionGenerator instructionGenerator = new RandomInstructionGenerator();
		PositionGenerator positionGenerator = new RandomPositionGenerator();
		Solver solver = new Solver();
		Generator g = new Generator(positionGenerator, instructionGenerator, solver);
		g.setPrinter(printer);
		g.generateCases();
	}

	private static void singleStepTest(AssignmentInputPrinter printer) {
		for(Direction direction : Direction.values()) {
			CaseFactory factory = new CaseFactory();
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
			CaseFactory factory = new CaseFactory();

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
			CaseFactory factory = new CaseFactory();
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
			CaseFactory factory = new CaseFactory();
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
		CaseFactory factory = new CaseFactory();
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
		CaseFactory factory = new CaseFactory();
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
}
