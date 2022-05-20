package by.it.arsenihlaz.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) throws CalcException {
        expression = expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.MATH_OPERATIONS, 2);

        if (parts.length == 1) {
            return Var.createVar(parts[0]);
        }

        String rightOperand = parts[1];
        Var right = Var.createVar(rightOperand);

        Pattern pattern = Pattern.compile(Patterns.MATH_OPERATIONS);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {
            String operation = matcher.group();

            if (operation.equals("=")) {
                return Var.save(parts[0], right);
            }

            String leftOperand = parts[0];
            Var left = Var.createVar(leftOperand);

            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
        }
        throw new CalcException("unknown expression: %s", expression);
    }
}
