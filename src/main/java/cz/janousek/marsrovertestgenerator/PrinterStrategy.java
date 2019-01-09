package cz.janousek.marsrovertestgenerator;

import java.io.IOException;

public interface PrinterStrategy {
    void print(String content) throws IOException;
}
