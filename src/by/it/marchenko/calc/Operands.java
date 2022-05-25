package by.it.marchenko.calc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.marchenko.calc.MessageConst.*;

public class Operands implements OperandProcessing {

    //Find operands in expression, remove spaces from operands if it is possible
    @Override
    public ArrayList<String> createOperands(String expression) throws CalcException {
        String[] availableOperands;
        ArrayList<String> operandList = new ArrayList<>();
        if (!expression.equals(EMPTY_STRING)) {
            availableOperands = expression.split(OPERATOR_REGEX);
            for (int i = 0; i < availableOperands.length; i++) {
                if (availableOperands[i].equals(EMPTY_STRING)) {
                    throw new CalcException(
                            INPUT_EXCEPTION + EMPTY_OPERAND_EXCEPTION + EMPTY_OPERAND_COMMENT);
                }
                String tempOperand = removeOperandInnerSpaces(availableOperands[i].trim());
                availableOperands[i] = removeOperandInnerSpaces(availableOperands[i].trim());
                operandList.add(tempOperand);
            }
        } else {
            throw new CalcException(
                    INPUT_EXCEPTION + EMPTY_EXPRESSION_EXCEPTION + EMPTY_EXPRESSION_COMMENT);
        }
        return operandList;
    }

    public String removeOperandInnerSpaces(String operand) throws CalcException {
        //TODO implement check correct operand for new type of Var...
        boolean isCorrectOperand =
                operand.matches(SCALAR_PATTERN) ||
                        operand.matches(VECTOR_PATTERN) ||
                        operand.matches(MATRIX_PATTERN) ||
                        operand.matches(VARIABLE_PATTERN);
        if (isCorrectOperand) {
            return operand.replaceAll(SPACES_REGEX, EMPTY_STRING);
        } else {
            throw new CalcException(
                    INPUT_EXCEPTION + MISSING_OPERATOR_EXCEPTION + MISSING_OPERATOR_COMMENT, operand);
        }
    }

    @Override
    public ArrayList<String> createOperators(String expression) {
        Pattern operatorPattern = Pattern.compile(OPERATOR_REGEX);
        Matcher operatorMatcher = operatorPattern.matcher(expression);
        ArrayList<String> operators = new ArrayList<>();
        while (operatorMatcher.find()) {
            operators.add(operatorMatcher.group());
        }
        return operators;
    }
}
