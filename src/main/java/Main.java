import commands.*;
import model.Canvas;
import model.CanvasImpl;
import model.EntityFactory;
import model.InvalidEntityException;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static Canvas         canvas;
    private static Scanner        scanner;
    private static CommandFactory commandFactory;
    private static EntityFactory  entityFactory;

    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        scanner = new Scanner(System.in);
        commandFactory = new CommandFactory();
        entityFactory = new EntityFactory();

        System.out.println("Enter command:");

        while (true) {
            process(scanner.nextLine());
            System.out.println("Enter command:");
        }
    }

    private static void process(String commandLine) {
        Command command = null;

        try {
            command = commandFactory.getCommand(commandLine);
        } catch (CommandNotFoundException e) {
            System.out.println("Please enter a valid command.");
        } catch (InvalidCommandParams invalidCommandParams) {
            System.out.println("Command syntax is not correct: " + invalidCommandParams.getMessage());
            System.out.println("Refer to following correct syntax: \n" + invalidCommandParams.getMessage());
        }

        if (command instanceof QuitCommand) {
            quit();
        }

        if (command instanceof CreateCanvas) {
            createNewCanvas((CreateCanvas) command);
            return;
        }

        if (command instanceof DrawEntityCommand) {
            draw((DrawEntityCommand) command);
        }
    }

    private static void draw(DrawEntityCommand command) {
        if (canvas == null) {
            System.out.println("You need to create a canvas first");
            return;
        }
        try {
            canvas.addEntity(entityFactory.getEntity(command));
            System.out.println(canvas.render());
        } catch (InvalidEntityException e) {
            System.out.println("Can not add the model to canvas: " + e.getMessage());
        }
    }

    private static void createNewCanvas(CreateCanvas command) {
        canvas = new CanvasImpl(command.getWidth(), command.getHeight());
        System.out.println(canvas.render());
    }

    private static void quit() {
        scanner.close();
        System.out.println("Exiting...");
        System.exit(0);
    }
}
