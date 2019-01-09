package cz.janousek.marsrovertestgenerator;

import java.util.List;

public class AssignmentInputPrinter implements Printer {

	@Override
	public void print(Case c) {
		System.out.println(generateOutput(c));
	}

	@Override
	public String generateOutput(Case c) {
		return String.format(
				"%s\n" +
				"\n" +
				"%s\n" +
				"\n" +
				"%d\n" +
				"\n" +
				"%s\n" +
				"\n" +
				"%s\n" +
				"\n" +
				"%s",
				makePositionOutput(c.configuration.getStartPosition()),
				c.configuration.getStartDirection().name(),
				c.configuration.getSize(),
				makePositionsOutput(c.configuration.getStones()),
				makePositionOutput(c.endPosition),
				c.configuration.getInstructions()
		);
	}

	private String makePositionsOutput(List<Position> stones) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stones.size(); i++) {
			sb.append(makePositionOutput(stones.get(i)));
			if (i < stones.size() - 1) {
				sb.append(";");
			}
		}
		return sb.toString();
	}

	private String makePositionOutput(Position p) {
		return String.format("%d,%d", p.x, p.y);
	}
}
