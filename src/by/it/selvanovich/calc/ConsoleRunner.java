package by.it.selvanovich.calc;

import by.it.selvanovich.calc.entity.Var;
import by.it.selvanovich.calc.exception.CalcException;
import by.it.selvanovich.calc.interfaces.Repository;
import by.it.selvanovich.calc.repository.PersistentRepository;
import by.it.selvanovich.calc.service.Parser;
import by.it.selvanovich.calc.service.Printer;
import by.it.selvanovich.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";
    public static final String MESSAGE_START_APP = "App started";
    public static final String MESSAGE_STOP_APP = "App finished";

    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(MESSAGE_START_APP);
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equals(COMMAND_END)) {
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

