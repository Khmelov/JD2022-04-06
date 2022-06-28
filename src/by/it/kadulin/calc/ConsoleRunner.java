package by.it.kadulin.calc;

import by.it.kadulin.calc.entity.Var;
import by.it.kadulin.calc.interfaces.Repository;
import by.it.kadulin.calc.repository.PersistentRepository;
import by.it.kadulin.calc.repository.VarMapRepository;
import by.it.kadulin.calc.service.Parser;
import by.it.kadulin.calc.service.Printer;
import by.it.kadulin.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String END = "end";
    public static final String MESSAGE_APP_STARTED = "App started";
    public static final String MESSAGE_APP_FINISHED = "App finished";

    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner sc = new Scanner(System.in);
        System.out.println(MESSAGE_APP_STARTED);
        while (sc.hasNext()) {
            String expression = sc.nextLine();
            if (expression.equals(END)) {
                break;
            }
            else {
                Var result = parser.startCalc(expression);
                printer.print(result);
            }
        }
        System.out.println(MESSAGE_APP_FINISHED);
    }
}
