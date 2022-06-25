package by.it.marchenko.calc.services;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.interfaces.CalcAppCommand;
import by.it.marchenko.calc.interfaces.Repository;

import java.util.*;

import static by.it.marchenko.calc.constant.MessageConst.*;

public class CalcCommander implements CalcAppCommand {
    private static HashMap<String, Var> variables;

    private static final Set<String> commands = new HashSet<>(Arrays.asList(
            COMMAND_APP_EXIT, COMMAND_PRINT_VARIABLE, COMMAND_SORT_VARIABLE
    ));

    public CalcCommander(Repository repository) {
        variables = repository.getAllVariables();
    }

    @Override
    public String performCommand(String command) throws CalcException {
        //command = command.toLowerCase();  // remove as trim() removing from std presentation
        if (command != null) {
            command = command.trim().toLowerCase();
        } else {
            throw new CalcException("Empty expression entered");
        }

        if (commands.contains(command)) {
            //variables =
            //repository.getAllVariables();
            return switch (command) {
                case COMMAND_PRINT_VARIABLE -> printVariable();
                case COMMAND_SORT_VARIABLE -> sortVariable();
                case COMMAND_APP_EXIT -> MESSAGE_FAREWELL;
                default -> null;
            };
        }
        return null;
    }

    private static String printVariable() {
        StringBuilder out = new StringBuilder("Available variables:");
        for (Map.Entry<String, Var> element : variables.entrySet()) {
            out.append("\n").append(element.getKey()).
                    append(ASSIGN_OPERATOR).append(element.getValue());
        }
        out.append("\n");
        return out.toString();
    }

    private static String sortVariable() {
        TreeMap<String, Var> sortedVariables = new TreeMap<>(variables);
        StringBuilder out = new StringBuilder("Available variables:");
        for (Map.Entry<String, Var> element : sortedVariables.entrySet()) {
            out.append("\n").append(element.getKey()).
                    append(ASSIGN_OPERATOR).append(element.getValue());
        }
        out.append("\n");
        return out.toString();
    }
}
