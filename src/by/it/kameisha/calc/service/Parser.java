package by.it.kameisha.calc.service;

import by.it.kameisha.calc.ResMan;
import by.it.kameisha.calc.constants.Errors;
import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.constants.Patterns;
import by.it.kameisha.calc.exception.CalcException;
import by.it.kameisha.calc.interfaces.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Repository repository;
    private final VarCreator varCreator;
    private ResMan resMan = ResMan.INSTANCE;
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
        while (expression.contains("(") && expression.contains(")")) {
            expression = calcInBracket(expression);
        }
        return calcVar(expression);
    }

    private Var calcVar(String expression) throws CalcException {
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATIONS)));
        List<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (!operations.isEmpty()) {
            int index = getPriority(operations);
            String left = operands.remove(index);
            String operation = operations.remove(index);
            String right = operands.remove(index);
            Var result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return varCreator.createVar(operands.get(0));
    }

    private String calcInBracket(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.OPERAND_IN_BRACKETS);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String result = matcher.group();
            Var var = calcVar(result.replace("(","").replace(")",""));
            expression = expression.replace(result, var.toString());
            return expression;
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
        throw new CalcException(resMan.get(Errors.NOT_FOUND_OPERATION) +" '%s'", operation);
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
