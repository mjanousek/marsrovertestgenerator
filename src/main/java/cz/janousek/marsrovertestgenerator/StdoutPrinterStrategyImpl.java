package cz.janousek.marsrovertestgenerator;

public class StdoutPrinterStrategyImpl implements PrinterStrategy {

    @Override
    public void print(String content) {
        System.out.println(content);
        System.out.println();
    }

}
