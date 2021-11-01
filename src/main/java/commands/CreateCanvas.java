package commands;

import utils.Util;

public class CreateCanvas implements Command{
    private static String helpMessage = "\'C w h\' to create a new canvas of width w and height h. w, h should be > 0";
    private int height;
    private int width;

    public CreateCanvas(String... params) {
        if (params.length < 2)
            throw new InvalidCommandParams("Create command expects 2 params", helpMessage);
        try {
            width = Util.positiveValue(params[0]);
            height = Util.positiveValue(params[1]);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandParams("Number must >= 0", helpMessage);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "CreateCanvas{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
