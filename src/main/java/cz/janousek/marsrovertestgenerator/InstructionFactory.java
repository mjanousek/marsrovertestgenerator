package cz.janousek.marsrovertestgenerator;

class InstructionFactory {

    private StringBuffer buffer = new StringBuffer();

    public InstructionFactory left() {
        buffer.append("L");

        return this;
    }

    public InstructionFactory left(int repeat) {
        for (int i = 0; i < repeat; i++) {
            left();
        }

        return this;
    }

    public InstructionFactory right() {
        buffer.append("R");

        return this;
    }

    public InstructionFactory right(int repeat) {
        for (int i = 0; i < repeat; i++) {
            right();
        }

        return this;
    }

    public InstructionFactory forward() {
        buffer.append("F");

        return this;
    }

    public InstructionFactory forward(int repeat) {
        for (int i = 0; i < repeat; i++) {
            forward();
        }

        return this;
    }

    public void backward() {
        buffer.append("B");
    }

    public InstructionFactory backward(int repeat) {
        for (int i = 0; i < repeat; i++) {
            backward();
        }

        return this;
    }

    public String getResult() {
        return buffer.toString();
    }

}
