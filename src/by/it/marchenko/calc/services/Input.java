package by.it.marchenko.calc.services;

import by.it.marchenko.calc.ConsoleRunner;
import by.it.marchenko.calc.constant.MessageConst;
import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.utility.ResourceManager;

import java.util.Scanner;

import static by.it.marchenko.calc.constant.MessageConst.*;

public class Input {
    private final Scanner console;
    private int expressionID;
    private String expression;
    private final MessageConst messageConst = new MessageConst();
    private static final ResourceManager resourceManager = ConsoleRunner.getResourceManager();

    public Input(Scanner console) {
        this.console = console;
        this.expression = EMPTY_STRING;
        this.expressionID = 0;
    }

    public String getExpression() {
        return this.expression;
    }

    public int getExpressionID() {
        return expressionID;
    }

    public void increaseExpressionID() {
        this.expressionID++;// = expressionID;
    }

    public void setExpression() throws CalcException {
        System.out.printf("% -3d %s ",
                getExpressionID() + 1,
                messageConst.getMESSAGE_DATA_INVITATION());
        expression = toStdPresentation(console.nextLine());
        this.increaseExpressionID();
    }

    public boolean runEnabled() {
        return !COMMAND_APP_EXIT.equalsIgnoreCase(this.expression);
    }

    private static String toStdPresentation(String expression) throws CalcException {
        if (expression.matches(SPACES_REGEX)) {
            throw new CalcException(resourceManager.getString(MESSAGE_EMPTY_EXPRESSION));
        }
        return expression.trim().replaceAll(SPACES_REGEX, EMPTY_STRING);
    }
}
