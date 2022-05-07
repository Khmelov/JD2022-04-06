package by.it.avramchuk.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";
    public static final String MESSEGE_START = "App started";
    public static final String MESSEGE_STOP = "App finished";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner  scanner = new Scanner(System.in);
        System.out.println(MESSEGE_START);
        while (scanner.hasNext()){
            String expression = scanner.nextLine();
            if (expression.equals(COMMAND_END)){
                break;
            } else {
                Var result = parser.calc(expression);
                printer.print(result);
            }

        }
        System.out.println(MESSEGE_STOP);

    }
}
