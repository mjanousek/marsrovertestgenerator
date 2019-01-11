package cz.janousek.marsrovertestgenerator;

import java.io.IOException;
import java.util.List;

public class AssignmentInputPrinter implements Printer {

	private PrinterStrategy strategy = new StdoutPrinterStrategyImpl();

	public void setStrategy(PrinterStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void print(Case c) {
		try {
			strategy.print(generateOutput(c));
		}catch(IOException ex) {
			System.err.println("Cannot write into file");
		}
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

	protected String makePositionsOutput(List<Position> stones) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stones.size(); i++) {
			sb.append(makePositionOutput(stones.get(i)));
			if (i < stones.size() - 1) {
				sb.append(";");
			}
		}
		return sb.toString();
	}

	protected String makePositionOutput(Position p) {
		return String.format("%d,%d", p.x, p.y);
	}
}
