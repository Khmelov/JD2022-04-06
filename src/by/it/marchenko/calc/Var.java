package by.it.marchenko.calc;

import static by.it.marchenko.calc.MessageConst.*;

abstract class Var implements Operation {
    final String VAR_TO_STRING_MESSAGE = "Unknown variable(abstract stub)";
    @Override
    public Var add(Var other) {
        printNotAvailableOperation(ADD_OPERATOR, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        printNotAvailableOperation(SUB_OPERATOR, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        printNotAvailableOperation(MUL_OPERATOR, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        printNotAvailableOperation(DIV_OPERATOR, other);
        return null;
    }

    @Override
    public String toString() {
        return VAR_TO_STRING_MESSAGE;
    }

    private void printNotAvailableOperation(String operator, Var other) {
        final String INCORRECT_OPERATION_MESSAGE = "Operation %s %s %s not available.%n";
        System.out.printf(INCORRECT_OPERATION_MESSAGE, this, operator, other);
    }

}
