package by.it.arsenihlaz.calculator.services;

import by.it.arsenihlaz.calculator.constants.Message;
import by.it.arsenihlaz.calculator.constants.Patterns;
import by.it.arsenihlaz.calculator.entity.Var;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.interfaces.Repository;
import by.it.arsenihlaz.calculator.util.ResourceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final ResourceManager resourceManager = ResourceManager.INSTANSE;
    private final Repository repository;
    private final VarCreator varCreator;
    private final static Map<String, Integer> priorityMap = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public Parser(Repository repository, VarCreator varCreator) {
        this.repository = repository;
        this.varCreator = varCreator;
    }

    public Var calc(String expression) throws CalcException {
        expression = expression.trim().replaceAll(Patterns.SPACES, "");

        while (expression.contains("(")) {
            expression = deleteBrackets(expression);
        }

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.MATH_OPERATIONS)));
        List<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(Patterns.MATH_OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        while (!operations.isEmpty()) {
            int index = getPriority(operations);
            String firstOperand = operands.remove(index);
            String operation = operations.remove(index);
            String secondOperand = operands.remove(index);
            Var result = calcOneOperation(firstOperand, operation, secondOperand);
            operands.add(index, result.toString());
        }
        return varCreator.createVar(operands.get(0));
    }

    // D=((C-0.15)-20)/(7-5)
    private String deleteBrackets(String expression) throws CalcException {
        Pattern pattern = Pattern.compile("\\([^()]+\\)");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String group = matcher.group();
            String replaceBrackets = group.replace("(", "")
                    .replace(")", "");
            expression = expression.replace(group, calc(replaceBrackets).toString());
        }
        return expression;
    }


    private Var calcOneOperation(String leftOperand, String operation, String rightOperand) throws CalcException {
        Var right = varCreator.createVar(rightOperand);
        if (operation.equals("=")) {
            return repository.save(leftOperand, right);
        }

        Var left = varCreator.createVar(leftOperand);
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
        throw new CalcException(resourceManager.getValue(Message.UNKNOWN_OPERATION) + " %s", operation);
    }

    private int getPriority(List<String> operations) {
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
}
