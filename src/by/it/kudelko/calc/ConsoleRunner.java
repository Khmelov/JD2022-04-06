package by.it.kudelko.calc;

import by.it.kudelko.calc.entity.Var;
import by.it.kudelko.calc.service.Parser;
import by.it.kudelko.calc.service.Printer;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String START_APP = "App started";
    public static final String FINISHED_APP = "App finished";
    public static final String COMMAND_END = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        System.out.println(START_APP);
        while (sc.hasNext()) {
            String expression = sc.nextLine();
            if (expression.equals(COMMAND_END)) {
                break;
            } else {
                Var result = parser.calc(expression);
                printer.print(result);
            }
        }
        System.out.println(FINISHED_APP);
    }
}
