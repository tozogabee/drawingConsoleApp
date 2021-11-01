package commands;

import java.util.Arrays;

public class CommandFactory {

    public Command getCommand(String commandLine) throws CommandNotFoundException, InvalidCommandParams {
        commandLine = commandLine.trim().replaceAll(" {1,}", " ");
        String[] split       = commandLine.split(" ");
        String   mainCommand = split[0].toUpperCase();
        String[] params      = Arrays.copyOfRange(split, 1, split.length);
        switch (mainCommand) {
            case "Q":
                return new QuitCommand();
            case "C":
                return new CreateCanvas(params);
            case "L":
                return new DrawLineCommand(params);
            case "R":
                return new DrawRectangleCommand(params);
            case "B":
                return new BucketFillCommand(params);
            default:
                throw new CommandNotFoundException("Command not found");
        }
    }
}
