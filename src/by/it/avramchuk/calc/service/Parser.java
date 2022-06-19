package by.it.avramchuk.calc.service;
import by.it._classwork_.calc.exception.CalcException;

import by.it.avramchuk.calc.constants.Patterns;
import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.interfaces.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Repository repository;
    private final VarCreator varCreator;

    public Parser(Repository repository, VarCreator varCreator) {
        this.repository = repository;
        this.varCreator = varCreator;
    }

    public Var calc(String expression) throws by.it.avramchuk.calc.exception.CalcException, CalcException {
        expression= expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts= expression.split(Patterns.OPERATIONS, 2);

        if (parts.length==1){
            return varCreator.createVar(parts[0]);
        }
        String right = parts[1];
        Var rightOperand = varCreator.createVar(right);

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()){
            String operation = matcher.group();
            if (operation.equals("=")){
               return repository.save(parts[0],rightOperand);
            }
            String left = parts[0];
            Var leftOperand = varCreator.createVar(left);

            switch (operation){
                case "+": return leftOperand.add(rightOperand);
                case "-": return leftOperand.sub(rightOperand);
                case "*": return leftOperand.mul(rightOperand);
                case "/": return leftOperand.div(rightOperand);
            }
        }
        throw new CalcException("unknown expression %s", expression);
    }
}
