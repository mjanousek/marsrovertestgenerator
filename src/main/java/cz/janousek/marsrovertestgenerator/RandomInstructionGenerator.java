package cz.janousek.marsrovertestgenerator;

public class RandomInstructionGenerator implements InstructionGenerator {
	@Override
	public String generate(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(Instruction.randomInstruction().name());
		}

		return sb.toString();
	}
}
