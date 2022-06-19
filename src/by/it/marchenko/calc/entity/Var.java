package by.it.marchenko.calc.entity;

import by.it.marchenko.calc.interfaces.Operation;

import static by.it.marchenko.calc.constant.MessageConst.*;

public abstract class Var implements Operation {

    final String VAR_TO_STRING_MESSAGE = "Unknown variable(abstract stub)";

    @Override
    public Var foundVarType(Var operand, String operator) {
        //System.out.println("FOUND VAR+VAR");
        return operand.foundVarType(this, operator);
    }

    @Override
    public Var foundVarType(Scalar operand, String operator) {
        //System.out.println("FOUND VAR+Scalar");
        return switch (operator) {
            case ADD_OPERATOR -> this.add(operand);
            case SUB_OPERATOR -> operand.sub(this);
            case MUL_OPERATOR -> operand.mul(this);
            case DIV_OPERATOR -> operand.div(this);
            //case ASSIGN_OPERATOR -> AssignMethod();
            default -> null;
        };
    }

    @Override
    public Var foundVarType(Vector operand, String operator) {
        //System.out.println("FOUND VAR+Vector");
        return switch (operator) {
            case ADD_OPERATOR -> this.add(operand);
            case SUB_OPERATOR -> operand.sub(this);
            case MUL_OPERATOR -> operand.mul(this);
            case DIV_OPERATOR -> operand.div(this);
            //case ASSIGN_OPERATOR -> AssignMethod();
            default -> null;
        };
    }

    @Override
    public Var foundVarType(Matrix operand, String operator) {
        //System.out.println("FOUND VAR+Matrix");
        return switch (operator) {
            case ADD_OPERATOR -> this.add(operand);
            case SUB_OPERATOR -> operand.sub(this);
            case MUL_OPERATOR -> operand.mul(this);
            case DIV_OPERATOR -> operand.div(this);
            //case ASSIGN_OPERATOR -> AssignMethod();
            default -> null;
        };
    }

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
        System.out.printf(INCORRECT_OPERATION_MESSAGE, other, operator, this);
    }

}
