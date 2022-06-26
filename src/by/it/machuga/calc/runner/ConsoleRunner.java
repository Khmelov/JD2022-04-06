package by.it.machuga.calc.runner;

import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.repasitory.PersistentRepository;
import by.it.machuga.calc.repasitory.Repository;
import by.it.machuga.calc.servise.Parser;
import by.it.machuga.calc.servise.Printer;
import by.it.machuga.calc.servise.VarCreator;

import java.util.Scanner;

import static by.it.machuga.calc.constans.ConstantStorage.END;

public class ConsoleRunner {

    public static void main(String[] args) {
        System.out.println(ConstantStorage.CALCULATOR_STARTED_MESSAGE);
        Printer printer = new Printer();
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConstantStorage.ENTER_EXPRESSION_MESSAGE);
        String expression = scanner.nextLine();
        while (!expression.equalsIgnoreCase(END)) {
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalculatorException e) {
                printer.print(e);
            }
            expression = scanner.nextLine();
        }
        System.out.println(ConstantStorage.CALCULATOR_STOPPED_MESSAGE);
    }
}
