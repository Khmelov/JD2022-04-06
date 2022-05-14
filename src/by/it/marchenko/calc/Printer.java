package by.it.marchenko.calc;


import static by.it.marchenko.calc.MessageConst.*;

public class Printer {

    public static void print(String out) {
        System.out.println(out);
    }

    public static void print(Input inputString, Var result) {

        if (inputString.getExpression() != null) {
            if (inputString.runEnabled()) {
                System.out.printf("%s % 2d: %s%n",
                        MESSAGE_PRINT_RESULT,
                        inputString.getExpressionNumber(),
                        //inputString.getExpression(),
                        result);
            } else {
                System.out.println(MESSAGE_FAREWELL);
            }
        }
    }

    public static void greeting() {
        System.out.println(MESSAGE_GREETING);
    }
}
