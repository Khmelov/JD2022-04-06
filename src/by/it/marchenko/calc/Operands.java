package by.it.marchenko.calc;

import static by.it.marchenko.calc.MessageConst.*;

public class Operands implements OperandProcessing {

    //Find operands in expression, remove spaces from operands if it is possible
    @Override
    public String[] createOperands(String expression) throws CalcException {
        String[] availableOperands;
        if (!expression.equals(EMPTY_STRING)) {
            availableOperands = expression.split(OPERATOR_REGEX);
            for (int i = 0; i < availableOperands.length; i++) {
                if (availableOperands[i].equals(EMPTY_STRING)) {
                    throw new CalcException(
                            INPUT_EXCEPTION + EMPTY_OPERAND_EXCEPTION + EMPTY_OPERAND_COMMENT);
                }
                availableOperands[i] = removeOperandInnerSpaces(availableOperands[i].trim());
            }
        } else {
            throw new CalcException(
                    INPUT_EXCEPTION + EMPTY_EXPRESSION_EXCEPTION + EMPTY_EXPRESSION_COMMENT);
        }
        return availableOperands;
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
}
