package by.it.penkrat.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";
    public static final String MESSAGE_START_APP = "App is started!";
    public static final String MESSAGE_CLOSED_APP = "App is finished!";

    public static void main(String[] args) {

        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        System.out.println(MESSAGE_START_APP);
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equals(COMMAND_END)) {
                break;
            } else {
                Var result = parser.calc(expression);
                printer.print(result);
            }
        }
        System.out.println(MESSAGE_CLOSED_APP);
    }
}
