package by.it.marchenko.jd01_10.calc;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static by.it.marchenko.jd01_10.MessageConst.*;
import static by.it.marchenko.jd01_10.calc.MessageConst.*;

public class Parser {

    @SuppressWarnings("ConstantConditions")
    public Var calc(String inputString) {
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
            Object tempResult = varOperands[0];
            for (int i = 0; i < operator.length; i++) {
                String methodName = switch (operator[i]) {
                    case ADD_OPERATOR -> ADD_STRING_OPERATOR;
                    case MUL_OPERATOR -> MUL_STRING_OPERATOR;
                    case SUB_OPERATOR -> SUB_STRING_OPERATOR;
                    case DIV_OPERATOR -> DIV_STRING_OPERATOR;
                    default -> null;
                };
                try {
                    Method method = tempResult.getClass().
                            getMethod(methodName, varOperands[i + 1].getClass().getSuperclass());
                    tempResult = method.invoke(tempResult, varOperands[i + 1]);
                } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            return (Var) tempResult;
        }
        return null;
    }
}
