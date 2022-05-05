package by.it.marchenko.jd01_09;

import static by.it.marchenko.jd01_09.MessageConst.MESSAGE_PRINT_RESULT;

public class Printer {
    public static void print(Input inputString, Var result) {
        if (inputString.getExpression() != null) {
            System.out.printf("%s % 2d: %s%n",
                    MESSAGE_PRINT_RESULT,
                    inputString.getExpressionNumber(),
                    //inputString.getExpression(),
                    result);
        }
    }
}
