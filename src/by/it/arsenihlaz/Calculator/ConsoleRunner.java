package by.it.arsenihlaz.Calculator;

import by.it.arsenihlaz.Calculator.entity.Var;
import by.it.arsenihlaz.Calculator.exception.CalcException;
import by.it.arsenihlaz.Calculator.interfaces.Repository;
import by.it.arsenihlaz.Calculator.repository.PersistentRepository;
import by.it.arsenihlaz.Calculator.repository.VarMapRepository;
import by.it.arsenihlaz.Calculator.services.Parser;
import by.it.arsenihlaz.Calculator.services.Printer;
import by.it.arsenihlaz.Calculator.services.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";

    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
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
    }
}
