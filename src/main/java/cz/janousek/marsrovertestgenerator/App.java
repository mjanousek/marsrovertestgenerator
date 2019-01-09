package cz.janousek.marsrovertestgenerator;

public class App {

	public static void main(String[] args) {
		InstructionGenerator instructionGenerator = new RandomInstructionGenerator();
		PositionGenerator positionGenerator = new RandomPositionGenerator();
		Solver solver = new Solver();
		Generator g = new Generator(positionGenerator, instructionGenerator, solver);
		g.generateCases();
	}
}
