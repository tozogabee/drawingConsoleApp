package command;

import commands.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CommandFactoryTest {

    CommandFactory commandFactory = new CommandFactory();

    @Test
    public void qAsCommand() {
        Command command = commandFactory.getCommand("Q");
        assertTrue(command instanceof QuitCommand);
    }

    @Test
    public void cAsCommand() {
        Command command = commandFactory.getCommand("C 20 10");
        assertTrue(command instanceof CreateCanvas);
    }

    @Test
    public void lAsCommand() {
        Command command = commandFactory.getCommand("L 5 4 5 2");
        assertTrue(command instanceof DrawLineCommand);
    }

    @Test
    public void rAsCommand() {
        Command command = commandFactory.getCommand("R 10 20 6 3");
        assertTrue(command instanceof DrawRectangleCommand);
    }

    @Test
    public void bAsCommand() {
        Command command = commandFactory.getCommand("B 10 9 O");
        assertTrue(command instanceof BucketFillCommand);
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void cAsInvalidCommand() {
        Command command = commandFactory.getCommand("C 20 -10");
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void lAsInvalidCommand() {
        Command command = commandFactory.getCommand("L 5 4 3 2");
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void rAsInvalidCommand() {
        Command command = commandFactory.getCommand("R 10 -20 6 3");
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void bAsInvalidCommand() {
        Command command = commandFactory.getCommand("B 10 9 OY");
        assertTrue(command instanceof BucketFillCommand);
    }

}
