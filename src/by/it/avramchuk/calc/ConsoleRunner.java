package by.it.avramchuk.calc;

import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.exception.CalcException;
import by.it.avramchuk.calc.interfaces.Repository;
import by.it.avramchuk.calc.repository.PersistentRepository;
import by.it.avramchuk.calc.repository.VarMapRepository;
import by.it.avramchuk.calc.service.Parser;
import by.it.avramchuk.calc.service.Printer;
import by.it.avramchuk.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";
    public static final String MESSEGE_START = "App started";
    public static final String MESSEGE_STOP = "App finished";

    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
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
