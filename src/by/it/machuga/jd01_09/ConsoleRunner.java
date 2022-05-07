package by.it.machuga.jd01_09;

import java.util.Scanner;

import static by.it.machuga.jd01_09.ConstantStorage.END;

public class ConsoleRunner {

    public static void main(String[] args) {
        System.out.println(ConstantStorage.CALCULATOR_STARTED_MESSAGE);
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConstantStorage.ENTER_EXPRESSION_MESSAGE);
        String expression = scanner.nextLine();
        while (!expression.equalsIgnoreCase(END)) {
            Var result = parser.calc(expression);
            printer.print(result);
            expression = scanner.nextLine();
        }
        System.out.println(ConstantStorage.CALCULATOR_STOPPED_MESSAGE);
    }
}
