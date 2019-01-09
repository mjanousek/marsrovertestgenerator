package cz.janousek.marsrovertestgenerator;

public class Case {
	public final Configuration configuration;
	public final Position endPosition;

	public Case(Configuration configuration, Position endPosition) {
		this.configuration = configuration;
		this.endPosition = endPosition;
	}
}
