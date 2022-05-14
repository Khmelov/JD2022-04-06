package by.it.marchenko.calc;

import java.util.HashMap;

import static by.it.marchenko.calc.MessageConst.*;

abstract class Var implements Operation {
    final String VAR_TO_STRING_MESSAGE = "Unknown variable(abstract stub)";

    private final static HashMap<String, Var> varMap = new HashMap<>();

    public static HashMap<String, Var> getVarMap() {
        return varMap;
    }

    static void saveVariable(String name, Var variable){
        varMap.put(name, variable);
        //return variable;
    }

    public static Var createVar(String operand) {
        if (operand.matches(SCALAR_PATTERN)) {
            return new Scalar(operand);
        } else if (operand.matches(VECTOR_PATTERN)) {
            return new Vector(operand);
        } else if (operand.matches(MATRIX_PATTERN)) {
            return new Matrix(operand);
        } else if (varMap.containsKey(operand)) {
            return varMap.get(operand);
        }
        return null;
    }

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
