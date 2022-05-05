package by.it.marchenko.jd01_09;

import java.util.Scanner;

import static by.it.marchenko.jd01_09.MessageConst.*;

public class Input {
    private final Scanner console;
    private int expressionNumber;
    private String expression;


    public Input(Scanner console) {
        this.console = console;
        this.expression = EMPTY_STRING;
        this.expressionNumber = 0;
    }

    public String getExpression() {
        return this.expression;
    }

    public int getExpressionNumber() {
        return expressionNumber;
    }

    public void setExpressionNumber(int expressionNumber) {
        this.expressionNumber = expressionNumber;
    }

    public void setExpression() {
        int number = this.getExpressionNumber();
        System.out.printf("% -3d %s ",
                ++number,
                MESSAGE_DATA_INVITATION);
        String tempExpression = console.nextLine();
        this.expression = Input.toStdPresentation(tempExpression);
        if (this.expression != null) {
            this.setExpressionNumber(number);
        }
    }

    public boolean runEnabled() {
        return !COMMAND_APP_EXIT.equalsIgnoreCase(this.expression);
    }

    private static String toStdPresentation(String expression) {
        if (expression.matches(SPACES_REGEX)) {
            System.out.println(MESSAGE_EMPTY_EXPRESSION);
            return null;
        }
        return expression.trim().replaceAll(SPACES_REGEX, EMPTY_STRING);
    }
}
