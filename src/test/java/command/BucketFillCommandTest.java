package command;

import commands.BucketFillCommand;
import commands.Command;
import commands.InvalidCommandParams;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class BucketFillCommandTest {
    Command bucketFillCommand;

    @Test
    public void bucketFillCommandSuccessFull() {
        bucketFillCommand = new BucketFillCommand("10","20","O");
        assertNotNull(bucketFillCommand);
        assertEquals(10, ((BucketFillCommand) bucketFillCommand).getX());
        assertEquals(20, ((BucketFillCommand) bucketFillCommand).getY());
        assertEquals('O', ((BucketFillCommand) bucketFillCommand).getC());
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void bucketFillCommandNotSuccessFullByNegativeNumber() {
        bucketFillCommand = new BucketFillCommand("10","-20","O");
    }

    @Test(expectedExceptions = InvalidCommandParams.class)
    public void bucketFillCommandNotSuccessFullByTwoCharacters() {
        bucketFillCommand = new BucketFillCommand("10","20","OC");
    }

}
