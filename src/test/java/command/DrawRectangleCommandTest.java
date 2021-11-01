package command;

import commands.Command;
import commands.DrawRectangleCommand;
import commands.InvalidCommandParams;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DrawRectangleCommandTest {
    Command drawingRectangle;

    @Test
    public void drawingRectangleCommandSuccessFull() {
        drawingRectangle = new DrawRectangleCommand("5","3","7","8");
        assertNotNull(drawingRectangle);
        assertEquals(5,((DrawRectangleCommand) drawingRectangle).getX1());
        assertEquals(3,((DrawRectangleCommand) drawingRectangle).getY1());
        assertEquals(7,((DrawRectangleCommand) drawingRectangle).getX2());
        assertEquals(8,((DrawRectangleCommand) drawingRectangle).getY2());
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void drawingCommandIsNotSuccessFull() {
        drawingRectangle = new DrawRectangleCommand("4","-5","6","9");
    }
}
