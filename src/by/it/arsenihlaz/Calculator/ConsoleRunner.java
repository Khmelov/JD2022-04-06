package by.it.arsenihlaz.Calculator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        VarMapRepository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equals(COMMAND_END)) {
                break;
            } else {
                Var result = null;
                try {
                    result = parser.calc(expression);
                } catch (CalcException e) {
                    printer.print(e);
                }
                Printer.print(result);
            }
        }
    }
}
