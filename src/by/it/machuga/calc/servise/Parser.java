package by.it.machuga.calc.servise;

import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.repasitory.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.machuga.calc.constans.ConstantStorage.*;

public class Parser {
    private final Repository repository;
    private final VarBuilder varBuilder;
    private final static Map<String, Integer> priorityMap = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public Parser(Repository repository, VarBuilder varBuilder) {
        this.repository = repository;
        this.varBuilder = varBuilder;
    }

    public Var calc(String expression) throws CalculatorException {
        while (!isSimpleExpression(expression)) {
            String simpleExpression = extractSimpleExpression(expression);
            String result = calculateSimpleExpression(simpleExpression).toString();
            expression = expression.replace(simpleExpression, result);
        }
        return calculateSimpleExpression(expression);
    }

    private String extractSimpleExpression(String expression) {
        Pattern pattern = Pattern.compile(SIMPLE_EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(expression);
        matcher.find();
        return matcher.group();
    }

    private boolean isSimpleExpression(String expression) {
        return !expression.contains(OPEN_BRACE);
    }

    private Var calculateSimpleExpression(String expression) throws CalculatorException {
        expression = expression.trim().replaceAll(SPACE, EMPTY_STRING).replace(OPEN_BRACE, EMPTY_STRING)
                .replace(CLOSE_BRACE, EMPTY_STRING);

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(OPERATION)));
        ArrayList<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(ConstantStorage.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (!operations.isEmpty()) {
            int index = getOperation(operations);
            String left = operands.remove(index);
            String operation = operations.remove(index);
            String right = operands.remove(index);
            Var result = executeOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return varBuilder.createVar(operands.get(0));
    }

    private int getOperation(List<String> operations) {
        int indexOperation = -1;
        int bestPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priorityMap.get(operation) > bestPriority) {
                indexOperation = i;
                bestPriority = priorityMap.get(operation);
            }
        }
        return indexOperation;
    }

    private Var executeOperation(String leftOperand, String operation, String rightOperand) throws CalculatorException {
        Var right = varBuilder.createVar(rightOperand);
        if (operation.equals("=")) {
            return repository.save(leftOperand, right);
        }
        Var left = varBuilder.createVar(leftOperand);
        return switch (operation) {
            case "+" -> left.add(right);
            case "-" -> left.sub(right);
            case "*" -> left.mul(right);
            case "/" -> left.div(right);
            default -> null;
        };
    }
}
