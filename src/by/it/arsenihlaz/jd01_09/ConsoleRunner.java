package by.it.arsenihlaz.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equals(COMMAND_END)) {
                break;
            } else {
                Var result = parser.calc(expression);
                Printer.print(result);
            }
        }
    }
}
