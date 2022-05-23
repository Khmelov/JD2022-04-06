package by.it.avramchuk.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) {
        expression= expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts= expression.split(Patterns.OPERATIONS, 2);

        if (parts.length==1){
            return Var.createVar(parts[0]);
        }
        String right = parts[1];
        Var rightOperand = Var.createVar(right);

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()){
            String operation = matcher.group();
            if (operation.equals("=")){
               return Var.save(parts[0],rightOperand);
            }
            String left = parts[0];
            Var leftOperand = Var.createVar(left);

            switch (operation){
                case "+": return leftOperand.add(rightOperand);
                case "-": return leftOperand.sub(rightOperand);
                case "*": return leftOperand.mul(rightOperand);
                case "/": return leftOperand.div(rightOperand);
            }
        }
        return  null;
    }
}
