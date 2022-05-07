package by.it.penkrat.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
// TODO fix Exeptions
    @SuppressWarnings("ConstantConditions")
    public Var calc(String expression) {

        //2+2   {2,2}+{2,6}  {{2,2},{2,2}} / 2

        String[] operand = expression.split(Patterns.OPERATION, 2);
        String leftOperand = operand[0];
        Var left = Var.createVar(leftOperand);
        if (operand.length == 1) {
            return left;
        }
        String rightOperand = operand[1];
        Var right = Var.createVar(rightOperand);

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if(matcher.find()){
            String signOperation = matcher.group();
            switch (signOperation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
