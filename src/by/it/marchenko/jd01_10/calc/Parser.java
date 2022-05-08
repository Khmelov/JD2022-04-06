package by.it.marchenko.jd01_10.calc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.marchenko.jd01_09.MessageConst.*;

public class Parser {

    @SuppressWarnings("ConstantConditions")
    public Var calc(String inputString) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (inputString != null) {
            String[] operands = inputString.split(OPERATOR_REGEX, MAXIMUM_ALLOWED_OPERANDS);
            Pattern operatorPattern = Pattern.compile(OPERATOR_REGEX);
            Matcher operatorMatcher = operatorPattern.matcher(inputString);
            String[] operator = new String[operands.length - 1];
            Var[] varOperands = new Var[operands.length];
            for (int i = 0; i < operands.length; i++) {
                varOperands[i] = Var.createVar(operands[i]);
                if (operatorMatcher.find()) {
                    operator[i] = operatorMatcher.group();
                }
            }
            Var tempResult = varOperands[0];
            for (int i = 0; i < operator.length; i++) {

                //Method methodForInvoke = tempResult.getClass().getMethod("add");
                //methodForInvoke.invoke(tempResult, varOperands[i + 1]);

                tempResult = switch (operator[i]) {
                    // TODO NullPointerException during invocation
                    case ADD_OPERATOR -> tempResult.add(varOperands[i + 1]);
                    case SUB_OPERATOR -> tempResult.sub(varOperands[i + 1]);
                    case MUL_OPERATOR -> tempResult.mul(varOperands[i + 1]);
                    case DIV_OPERATOR -> tempResult.div(varOperands[i + 1]);
                    default -> null;
                };
            }
            return tempResult;
        }
        return null;
    }
}
