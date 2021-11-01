package command;

import commands.Command;
import commands.DrawLineCommand;
import commands.InvalidCommandParams;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DrawLineCommandTest {
    Command drawingLineCommand;

    @Test
    public void drawingCommandSuccessFull(){
        drawingLineCommand = new DrawLineCommand("10","2","10","2");
        assertNotNull(drawingLineCommand);
        assertEquals(10, ((DrawLineCommand) drawingLineCommand).getX1());
        assertEquals(10,((DrawLineCommand) drawingLineCommand).getX2());
        assertEquals(2,((DrawLineCommand) drawingLineCommand).getY1());
        assertEquals(2,((DrawLineCommand) drawingLineCommand).getY2());
    }

    @Test
    public void drawingCommandSuccessFull2(){
        drawingLineCommand = new DrawLineCommand("10","4","10","2");
        assertNotNull(drawingLineCommand);
        assertEquals(10, ((DrawLineCommand) drawingLineCommand).getX1());
        assertEquals(10,((DrawLineCommand) drawingLineCommand).getX2());
        assertEquals(4,((DrawLineCommand) drawingLineCommand).getY1());
        assertEquals(2,((DrawLineCommand) drawingLineCommand).getY2());
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void drawingCommandX1AndX2NotEqual(){
        drawingLineCommand = new DrawLineCommand("10","5","9","2");
    }
}
