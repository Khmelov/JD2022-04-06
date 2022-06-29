package by.it.selvanovich.calc.service;

import by.it.selvanovich.calc.contants.Patterns;
import by.it.selvanovich.calc.entity.Var;
import by.it.selvanovich.calc.exception.CalcException;
import by.it.selvanovich.calc.interfaces.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

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
            expression = getSimpleExpression(expression);
        }
        //A=2+3*4
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
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
        throw new CalcException("not found operation '%s'", operation);
    }

    private int getPriority(List<String> operations) {
        int indexOperation = -1;
        int bestPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priorityMap.get(operation)>bestPriority){
                indexOperation=i;
                bestPriority=priorityMap.get(operation);
            }
        }
        return indexOperation;
    }

    public String getSimpleExpression(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.SIMPLE_EXP);
        Matcher matcher = pattern.matcher(expression);
        if(matcher.find()) {
            String target = matcher.group();
            String simpleExp= target.replace("(","")
                    .replace(")","");
            expression = expression.replace(target, calc(simpleExp).toString());
        }
        return expression;
    }
}
