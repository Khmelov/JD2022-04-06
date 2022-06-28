package by.it.annazhegulovich.jd02_06_b.calc;

import by.it.annazhegulovich.jd02_06_b.calc.entity.Var;
import by.it.annazhegulovich.jd02_06_b.calc.exception.CalcException;
import by.it.annazhegulovich.jd02_06_b.calc.interfaces.Repository;
import by.it.annazhegulovich.jd02_06_b.calc.repository.PersistentRepository;
import by.it.annazhegulovich.jd02_06_b.calc.service.Parser;
import by.it.annazhegulovich.jd02_06_b.calc.service.Printer;
import by.it.annazhegulovich.jd02_06_b.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String Command_END = "end";
    public static final String Message_START_APP = "App started";
    public static final String Message_STOP_APP = "App finished";

    public static void main(String[] args) {
        Printer printer= new Printer(System.out);
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(Message_START_APP);
        while (scanner.hasNext()){
            String expression = scanner.nextLine();
            if (expression.equals(Command_END)){
                break;
            } else{
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                } catch (CalcException e){
            printer.print(e);
                }
            }
        }
        System.out.println(Message_STOP_APP);
    }


}
