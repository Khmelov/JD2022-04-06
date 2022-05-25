package by.it.marchenko.calc;

import static by.it.marchenko.calc.MessageConst.*;

public class Operands implements OperandProcessing {

    //Find operands in expression
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
                //availableOperands[i] = availableOperands[i].trim();
                availableOperands[i] = removeOperandInnerSpaces(availableOperands[i].trim());

            }
        } else {
            throw new CalcException(
                    INPUT_EXCEPTION + EMPTY_EXPRESSION_EXCEPTION + EMPTY_EXPRESSION_COMMENT);
        }
        return availableOperands;
    }

    public String removeOperandInnerSpaces(String operand) throws CalcException {
        boolean isCorrectOperand =
                operand.matches(SCALAR_PATTERN) ||
                        operand.matches(VECTOR_PATTERN) ||
                        operand.matches(MATRIX_PATTERN) ||
                        operand.matches(VARIABLE_PATTERN);
        if (isCorrectOperand) {
            return operand.replaceAll(SPACES_REGEX, EMPTY_STRING);
        } else {
            throw new CalcException(
                    INPUT_EXCEPTION+MISSING_OPERATOR_EXCEPTION+MISSING_OPERATOR_COMMENT, operand);
        }
    }
}
