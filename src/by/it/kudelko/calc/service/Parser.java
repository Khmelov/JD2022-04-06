package by.it.kudelko.calc.service;

import by.it.kudelko.calc.contants.Patterns;
import by.it.kudelko.calc.entity.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) {
        expression.trim().replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        String LeftOperand = parts[0];
        Var left = Var.createVar(LeftOperand);
        if (parts.length == 1) {
            return left;
        }
        String RightOperand = parts[1];
        Var right = Var.createVar(RightOperand);

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
