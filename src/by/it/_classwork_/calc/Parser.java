package by.it._classwork_.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    //TODO fix after add exception
    @SuppressWarnings("ConstantConditions")
    public Var calc(String expression) {
        expression = expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return Var.createVar(parts[0]);
        }
        //A=2
        String rightOperand = parts[1];
        Var right = Var.createVar(rightOperand);

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
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

        return null;
    }
}
