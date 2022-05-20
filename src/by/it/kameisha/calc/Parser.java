package by.it.kameisha.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Repository repository;
    private final VarCreator varCreator;

    public Parser(Repository repository, VarCreator varCreator) {
        this.repository = repository;
        this.varCreator = varCreator;
    }

    public Var calc(String expression) throws CalcException {
        expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATIONS, 2);
        if (parts.length == 1) {
            return varCreator.createVar(parts[0]);
        }
        String leftOperand = parts[0];
        Var left = varCreator.createVar(leftOperand);
        String rightOperand = parts[1];
        Var right = varCreator.createVar(rightOperand);

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            if (operation.equals("=")) {
                return repository.save(parts[0], right);
            }
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
