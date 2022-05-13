package by.it.marchenko.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer.greeting();
        Scanner console = new Scanner(System.in);
        Input inputString = new Input(console);
        Parser parseString = new Parser();
        while (inputString.runEnabled()) {
            inputString.setExpression();
            String tempString = inputString.getExpression();
            Var result = parseString.calc(tempString);
            Printer.print(inputString, result);
        }
    }
}
