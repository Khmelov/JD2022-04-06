package by.it.marchenko.calc;

import java.util.*;

import static by.it.marchenko.calc.MessageConst.*;

public class Commander {
    private static final Set<String> commands = new HashSet<>();

    public static void loadCommand() {
        commands.add(COMMAND_APP_EXIT);
        commands.add(COMMAND_PRINT_VARIABLE);
        commands.add(COMMAND_SORT_VARIABLE);
    }

    public static String performCommand(String command) {
        command = command.toLowerCase();

        if (commands.contains(command)) {
            return switch (command) {
                case COMMAND_PRINT_VARIABLE -> printVariable(Var.getVarMap());
                case COMMAND_SORT_VARIABLE -> sortVariable(Var.getVarMap());
                case COMMAND_APP_EXIT -> MESSAGE_FAREWELL;
                default -> null;
            };
        }
        return null;
    }

    private static String printVariable(HashMap<String, Var> variables) {
        StringBuilder out = new StringBuilder("Available variables:");
        for(Map.Entry<String,Var> element: variables.entrySet()) {
            out.append("\n").append(element.getKey()).
                    append(ASSIGN_OPERATOR).append(element.getValue());
        }
        out.append("\n");
        return out.toString();
    }

    private static String sortVariable(HashMap<String, Var> variables) {
        TreeMap<String,Var> sortedVariables = new TreeMap<>(variables);
        StringBuilder out = new StringBuilder("Available variables:");
        for(Map.Entry<String,Var> element: sortedVariables.entrySet()) {
            out.append("\n").append(element.getKey()).
                    append(ASSIGN_OPERATOR).append(element.getValue());
        }
        out.append("\n");
        return out.toString();
    }
}
