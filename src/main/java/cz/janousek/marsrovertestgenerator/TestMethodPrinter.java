package cz.janousek.marsrovertestgenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class TestMethodPrinter extends AssignmentInputPrinter {

    private static AtomicInteger counter = new AtomicInteger(1);
    public boolean expectedResult;

    public TestMethodPrinter(boolean expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Override
    public String generateOutput(Case c) {
        return String.format(
                "\t@Test\n" +
                "\tpublic void test%d() {\n" +
                "\t\tString input =\n" +
                "\t\t\t\"%s\" +\n" +
                "\t\t\t\"\" +\n" +
                "\t\t\t\"%s\" +\n" +
                "\t\t\t\"\" +\n" +
                "\t\t\t\"%d\" +\n" +
                "\t\t\t\"\" +\n" +
                "\t\t\t\"%s\" +\n" +
                "\t\t\t\"\" +\n" +
                "\t\t\t\"%s\" + \n" +
                "\t\t\t\"\" + \n" +
                "\t\t\t\"%s\";\n\n" +
                "\t\tApplication application = new Application();\n" +
                "\t\tString actualOutput = application.runMethod(input);\n" +
                "\n" +
                "\t\tString expectedOutput = \"%s\";\n" +
                "\t\tassertEquals(expectedOutput, actualOutput);\n" +
                "\t}",
                counter.getAndIncrement(),
                makePositionOutput(c.configuration.getStartPosition()),
                c.configuration.getStartDirection().name(),
                c.configuration.getSize(),
                makePositionsOutput(c.configuration.getStones()),
                makePositionOutput(c.endPosition),
                c.configuration.getInstructions(),
                this.expectedResult ? "TRUE" : "FALSE"
        );
    }
}
