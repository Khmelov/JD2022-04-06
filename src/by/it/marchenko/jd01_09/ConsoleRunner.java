package by.it.marchenko.jd01_09;

import java.util.Scanner;

import static by.it.marchenko.jd01_09.MessageConst.*;

public class ConsoleRunner {
    public static void main(String[] args) {
        System.out.println(MESSAGE_GREETING);
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
