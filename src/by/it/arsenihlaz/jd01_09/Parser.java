package by.it.arsenihlaz.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) {
        expression = expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.MATH_OPERATIONS, 2);
        Var leftOperand = Var.createVar(parts[0]);
        if (parts.length == 1) {
            return leftOperand;
        }
        Var rightOperand = Var.createVar(parts[1]);
        Pattern pattern = Pattern.compile(Patterns.MATH_OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return leftOperand.add(rightOperand);
                case "-":
                    return leftOperand.sub(rightOperand);
                case "*":
                    return leftOperand.mul(rightOperand);
                case "/":
                    return leftOperand.div(rightOperand);
            }
        }
        return null;
    }
}
