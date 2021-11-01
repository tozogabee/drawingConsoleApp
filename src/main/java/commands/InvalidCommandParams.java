package commands;

public class InvalidCommandParams extends RuntimeException{
    private String help;

    public InvalidCommandParams(String message,String help) {
        super(message);
        help = help;
    }

    public String getHelp() {
        return help;
    }
}
