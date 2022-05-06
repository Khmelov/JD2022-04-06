package by.it.smirnov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String input) {
        try {
            input = input.trim().replaceAll("\\s+", "");
            String[] operands = input.split(Patterns.OPERATION, 2);
            Var leftOperand = Var.createVar(operands[0]);
            if (operands.length == 1) return leftOperand;
            Var rightOperand = Var.createVar(operands[1]);
            //if (leftOperand == null || rightOperand == null) return null;
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String operation = matcher.group();
                switch (operation) {
                    case "+": return leftOperand.add(rightOperand);
                    case "-": return leftOperand.sub(rightOperand);
                    case "*": return leftOperand.mul(rightOperand);
                    case "/": return leftOperand.div(rightOperand);
                }
            }

        }
        catch (NullPointerException nPE) {
            System.out.println("Incorrect input: Как минимум один из операндов = null");
        }
        return null;
    }
}
