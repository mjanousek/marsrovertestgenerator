package cz.janousek.marsrovertestgenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionFactoryTest {

    @Test
    void testSingleLeft() {
        InstructionFactory f = new InstructionFactory();
        f.left();

        assertEquals("L", f.getResult());
    }

    @Test
    void testMultipleLeft() {
        InstructionFactory f = new InstructionFactory();
        f.left(3);

        assertEquals("LLL", f.getResult());
    }

    @Test
    void testSingleRight() {
        InstructionFactory f = new InstructionFactory();
        f.right();

        assertEquals("R", f.getResult());
    }

    @Test
    void testMultipleRight() {
        InstructionFactory f = new InstructionFactory();
        f.right(3);

        assertEquals("RRR", f.getResult());
    }

    @Test
    void testSingleForward() {
        InstructionFactory f = new InstructionFactory();
        f.forward();

        assertEquals("F", f.getResult());
    }

    @Test
    void testMultipleForward() {
        InstructionFactory f = new InstructionFactory();
        f.forward(3);

        assertEquals("FFF", f.getResult());
    }

    @Test
    void testSingleBackward() {
        InstructionFactory f = new InstructionFactory();
        f.backward();

        assertEquals("B", f.getResult());
    }

    @Test
    void testMultipleBackward() {
        InstructionFactory f = new InstructionFactory();
        f.backward(3);

        assertEquals("BBB", f.getResult());
    }

}
