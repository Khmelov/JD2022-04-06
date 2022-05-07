package by.it.kadulin.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String END = "end";
    public static final String MESSAGE_APP_STARTED = "App started";
    public static final String MESSAGE_APP_FINISHED = "App finished";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        System.out.println(MESSAGE_APP_STARTED);
        while (sc.hasNext()) {
            String expression = sc.nextLine();
            if (expression.equals(END)) {
                break;
            }
            else {
                Var result = parser.calc(expression);
                printer.print(result);
            }
        }
        System.out.println(MESSAGE_APP_FINISHED);
    }
}
