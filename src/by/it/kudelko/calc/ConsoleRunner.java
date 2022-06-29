package by.it.kudelko.calc;

import by.it.kudelko.calc.entity.Var;
import by.it.kudelko.calc.exception.CalcException;
import by.it.kudelko.calc.interfaces.Repository;
import by.it.kudelko.calc.logger.Logger;
import by.it.kudelko.calc.repository.PersistentRepository;
import by.it.kudelko.calc.service.Parser;
import by.it.kudelko.calc.service.Printer;
import by.it.kudelko.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String MESSAGE_START_APP = "App started";
    public static final String MESSAGE_STOP_APP = "App finished";
    public static final String COMMAND_END = "end";

    public static void main(String[] args) {
        Logger logger = Logger.INSTANCE;
        Printer printer = new Printer(System.out);
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner sc = new Scanner(System.in);
        System.out.println(MESSAGE_START_APP);
        while (sc.hasNext()) {
            String expression = sc.nextLine();
            if (expression.equals(COMMAND_END)) {
                break;
            } else {
                try {
                Var result = parser.calc(expression);
                printer.print(result);
                logger.info("Сalculation result: " + result);
            } catch (CalcException e){
                printer.print(e);
                logger.error(e.getMessage());
                }
            }
        }
        System.out.println(MESSAGE_STOP_APP);
    }
}
