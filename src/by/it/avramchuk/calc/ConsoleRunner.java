package by.it.avramchuk.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";
    public static final String MESSEGE_START = "App started";
    public static final String MESSEGE_STOP = "App finished";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);

        Parser parser = new Parser(repository, varCreator);
        Scanner  scanner = new Scanner(System.in);
        System.out.println(MESSEGE_START);
        while (scanner.hasNext()){
            String expression = scanner.nextLine();
            if (expression.equals(COMMAND_END)){
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
        System.out.println(MESSEGE_STOP);

    }
}
