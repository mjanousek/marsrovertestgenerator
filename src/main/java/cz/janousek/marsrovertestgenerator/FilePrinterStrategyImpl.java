package cz.janousek.marsrovertestgenerator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class FilePrinterStrategyImpl implements PrinterStrategy {

    private final AtomicInteger refNumber = new AtomicInteger(0);
    private final String outputDirectory;

    public FilePrinterStrategyImpl(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    @Override
    public void print(String content) throws IOException {
        int n = refNumber.addAndGet(1);

        PrintWriter writer = new PrintWriter(
                outputDirectory + "test_" + n + ".txt",
                "UTF-8"
        );

        writer.println(content);
        writer.close();
    }

}
