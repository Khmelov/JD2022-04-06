package by.it.marchenko.jd01_15;

import java.util.*;

import static by.it.marchenko.jd01_15.Constants.*;

public class TaskC {


    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        CommandFinder commandFinder = new CommandFinder();

        System.out.println(GREETING_MESSAGE);

        while (true) {
            String commandline = console.nextLine();
            LinkedList<String> commandList = commandFinder.findCommand(commandline);

            String command = commandList.getFirst();
            String argument = commandList.getLast();

            System.out.println(switch (command) {
                case SHOW_DIRECTORY_COMMAND -> "perform dir";
                case CHANGE_DIRECTORY_COMMAND -> "perform cd";
                case EXIT_APP_COMMAND -> FAREWELL_MESSAGE;
                default -> COMMAND_NOT_FOUND_MESSAGE;
            });
            //System.out.println("We found command: " + command);
            //System.out.println("Command argument: " + argument);
            if (EXIT_APP_COMMAND.equalsIgnoreCase(command)) {
                break;
            }
        }

    }
}
