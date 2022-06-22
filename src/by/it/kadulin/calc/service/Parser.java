package by.it.kadulin.calc.service;

import by.it.kadulin.calc.constans.Patterns;
import by.it.kadulin.calc.entity.Var;
import by.it.kadulin.calc.interfaces.Repository;

import java.util.*;
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

    public Var startCalc(String expression) {
        expression = expression.trim().replaceAll(Patterns.SPACES, "");
        if (expression.contains("(")) {
            Pattern pattern = Pattern.compile(Patterns.ROUND_BRACKETS);
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find()) {
//            System.out.println(matcher.start());
                String founded = matcher.group().replace("(", "").replace(")", "");
                founded = calcPart(founded).toString();
//            System.out.println(founded);
//            System.out.println(matcher.end());
                StringBuilder sb = new StringBuilder();
                sb.append(expression.substring(0, matcher.start()));
                sb.append(founded);
                sb.append(expression.substring(matcher.end(), expression.length()));
                expression = sb.toString();
                matcher = pattern.matcher(expression);
//            System.out.println(sb);
//            expression = expression.substring(matcher.start(), matcher.end());
            }
        }
        else {
            expression = calcPart(expression).toString();
        }
        if (expression.contains(Patterns.OPERATIONS)) {
            expression = calcPart(expression).toString();
        }

        return varCreator.createVar(expression);
    }

    public Var calcPart(String expression) {
//        expression = expression.trim().replaceAll(Patterns.SPACES, "");
        List<String> operands = new ArrayList(Arrays.asList(expression.split(Patterns.OPERATIONS)));
        ArrayList<String> operations = new ArrayList<>();

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

    private Var calcOneOperation(String leftOperand, String operation, String rightOperand) {
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
        return null;
    }

    private int getPriority(ArrayList<String> operations) {
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
