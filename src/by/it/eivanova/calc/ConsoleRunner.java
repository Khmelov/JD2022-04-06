package by.it.eivanova.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String MESSAGE_START_APP = "App started";
    public static final String MESSAGE_STOP_APP = "App finished";
    public static final String COMMAND_END = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(MESSAGE_START_APP);
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase(COMMAND_END)) {
                break;
            } else {
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            }
        }
        System.out.println(MESSAGE_STOP_APP);
    }
}
