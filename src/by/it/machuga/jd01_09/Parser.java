package by.it.machuga.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.machuga.jd01_09.ConstantStorage.*;

public class Parser {
    public Var calc(String expression) {
        String[] operands = getOperands(expression);
        String leftOperand = operands[0];
        Var left = Var.createVar(leftOperand);
        if (operands.length == 1) {
            return left;
        }
        String rightOperand = operands[1];
        Var right = Var.createVar(rightOperand);
        String operation = getOperation(expression);
        return executeOperation(left, right, operation);
    }

    private String getOperation(String expression) {
        Pattern pattern = Pattern.compile(OPERATION);
        Matcher matcher = pattern.matcher(expression);
        String operation = EMPTY_STRING;
        if (matcher.find()) {
            operation = matcher.group();
        }
        return operation;
    }

    private Var executeOperation(Var left, Var right, String operation) {
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
            default:
                return null;
        }
    }

    private String[] getOperands(String expression) {
        expression = expression.trim().replaceAll(SPACE, EMPTY_STRING);
        String[] operands = expression.split(OPERATION, 2);
        return operands;
    }
}
