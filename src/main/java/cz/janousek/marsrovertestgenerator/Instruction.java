package cz.janousek.marsrovertestgenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Instruction {
	F,B,L,R;

	private static final Random RANDOM = new Random();

	public static Instruction randomInstruction()  {
		int random = RANDOM.nextInt(10);
		if (random < 1) {
			return B;
		} else if (random < 4) {
			return F;
		} else if (random < 7) {
			return L;
		} else {
			return R;
		}
	}
}
