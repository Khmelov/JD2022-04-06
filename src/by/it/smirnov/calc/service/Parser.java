package by.it.smirnov.calc.service;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.smirnov.calc.constants.Patterns.IN_BRACES;
import static by.it.smirnov.calc.constants.Patterns.OPERATION;

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


    public Var calc(String input) throws CalcException {
        input = input.trim().replaceAll("\\s+", "");
        input = inBraceCalc(input);
        Var result = makeCalculation(input);
        return result;
    }

    private String inBraceCalc(String input) throws CalcException {
        while (true) {
            Pattern pattern = Pattern.compile(IN_BRACES);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String braced = matcher.group();
                String deBraced = deBrace(braced);
                Var vars = makeCalculation(deBraced);
                input = input.replace(braced, vars.toString());
            } else break;
        }
        return input;
    }

    String deBrace(String braced) {
        braced = braced.replaceAll("\\)", "");
        braced = braced.replaceAll("\\(", "");
        return braced;
    }

    private Var makeCalculation(String input) throws CalcException {
        List<String> operands = new ArrayList<>(Arrays.asList(input.split(OPERATION)));
        List<String> operations = new ArrayList<>();
        Pattern pattern = Pattern.compile(OPERATION);
        Matcher matcher = pattern.matcher(input);
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

    private Var calcOneOperation(String leftOper, String operation, String rightOper) throws CalcException {
        Var right = varCreator.createVar(rightOper);
        if (operation.equals("=")) {
            return repository.saveVar(leftOper, right);
        }
        Var left = varCreator.createVar(leftOper);
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
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priorityMap.get(operation) > priority) {
                index = i;
                priority = priorityMap.get(operation);
            }
        }
        return index;
    }
}
