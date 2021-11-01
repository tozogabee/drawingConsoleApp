package commands;

import utils.Util;

public class BucketFillCommand implements Command{
    private static final String helpMessage = "B x y c, Should fill the entire area connected to (x,y) with \"colour\" c. The behavior of this is the same as that of the \"bucket fill\" tool in paint programs.";
    private int x;
    private int y;
    private char c;

    public BucketFillCommand(String... params) {
        if (params.length < 3)
            throw new InvalidCommandParams("Bucket fill expects 3 params", helpMessage);
        if (params[2].length() != 1)
            throw new InvalidCommandParams("Color character must be 1 character", helpMessage);
        try {
            x = Util.positiveValue(params[0]);
            y = Util.positiveValue(params[1]);
            c = params[2].charAt(0);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandParams("x or y should be greater than 0", helpMessage);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getC() {
        return c;
    }
}
