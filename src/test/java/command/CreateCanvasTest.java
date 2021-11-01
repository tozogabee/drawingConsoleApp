package command;

import commands.Command;
import commands.CreateCanvas;
import commands.InvalidCommandParams;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateCanvasTest {

    private Command canvasCreation;

    @Test
    public void canvasCreatedSuccesFully() {
        canvasCreation = new CreateCanvas("10","20");
        assertNotNull(canvasCreation);
        assertEquals(20, ((CreateCanvas) canvasCreation).getHeight());
        assertEquals(10, ((CreateCanvas) canvasCreation).getWidth());
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void gettingExceptionWhenWidthIsNegative() {
        canvasCreation = new CreateCanvas("-7","10");
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void gettingExceptionWhenHeightIsNegative() {
        canvasCreation = new CreateCanvas("7","-10");
    }
}
