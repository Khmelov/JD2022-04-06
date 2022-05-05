package by.it.marchenko.jd01_09;

import static by.it.marchenko.jd01_09.MessageConst.*;

public class Printer {
    public static void print(Input inputString, Var result) {
        if (inputString.getExpression() != null) {
            if (inputString.runEnabled()){
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
}
