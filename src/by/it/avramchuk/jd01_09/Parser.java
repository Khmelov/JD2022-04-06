package by.it.avramchuk.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) {
        expression= expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts= expression.split(Patterns.OPERATIONS, 2);
        String left = parts[0];
        Var leftOperand = Var.createVar(left);
        if (parts.length==1){
            return leftOperand;
        }

        String right = parts[1];
        Var rightOperand = Var.createVar(right);

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
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
