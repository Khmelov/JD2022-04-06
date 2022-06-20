package by.it.avramchuk.calc.service;
import by.it.avramchuk.calc.exception.CalcException;

import by.it.avramchuk.calc.constants.Patterns;
import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.interfaces.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Repository repository;
    private final VarCreator varCreator;
    private final  static Map<String, Integer> priorityMap= Map.of(
            "=",0,
            "+",1,
            "-",1,
            "*",2,
            "/",2
    );

    public Parser(Repository repository, VarCreator varCreator) {
        this.repository = repository;
        this.varCreator = varCreator;
    }

    public Var calc(String expression) throws CalcException {
        expression= expression.trim().replaceAll(Patterns.SPACES, "");

        List<String> operands = new ArrayList<> ( Arrays.asList(expression.split(Patterns.OPERATIONS)));
        ArrayList<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()){
            operations.add(matcher.group());
        }
        while(!operations.isEmpty()) {
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

            if (operation.equals("=")){
                return repository.save(leftOperand,right);
            }
            Var left = varCreator.createVar(leftOperand);

            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }

        throw new CalcException("not found operation '%s'", operation);
    }

    private int getPriority(ArrayList<String> operations) {
        int indexOperation = -1;
        int bestPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priorityMap.get(operation)>bestPriority){
                indexOperation= i;
                bestPriority = priorityMap.get(operation);
            }

        }
        return indexOperation;
    }
}
