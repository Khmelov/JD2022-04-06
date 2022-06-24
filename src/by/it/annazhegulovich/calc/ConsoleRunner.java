package by.it.annazhegulovich.calc;

import by.it.annazhegulovich.calc.entity.Var;
import by.it.annazhegulovich.calc.exception.CalcException;
import by.it.annazhegulovich.calc.interfaces.Repository;
import by.it.annazhegulovich.calc.repository.PersistentRepository;
import by.it.annazhegulovich.calc.service.Parser;
import by.it.annazhegulovich.calc.service.Printer;
import by.it.annazhegulovich.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String Command_END = "end";
    public static final String Massege_START_APP = "App started";
    public static final String Massege_STOP_APP = "App finished";

    public static void main(String[] args) {
        Printer printer= new Printer(System.out);
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(Massege_START_APP);
        while (scanner.hasNext()){
            String expression = scanner.nextLine();
            if (expression.equals(Command_END)){
                break;
            } else{
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                } catch (CalcException e){
            printer.print(e);}
            }
        }
        System.out.println(Massege_STOP_APP);
    }


}
