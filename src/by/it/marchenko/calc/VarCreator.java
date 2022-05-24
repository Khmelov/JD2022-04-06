package by.it.marchenko.calc;

//import java.util.Objects;

import static by.it.marchenko.calc.MessageConst.*;

public class VarCreator {
    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String operand) throws CalcException {
        Var createdVar;
        if (operand.matches(SCALAR_PATTERN)) {
            createdVar = new Scalar(operand);
        } else if (operand.matches(VECTOR_PATTERN)) {
            createdVar = new Vector(operand);
        } else if (operand.matches(MATRIX_PATTERN)) {
            createdVar = new Matrix(operand);
        } else if (repository.getAllVariables().containsKey(operand)) {
            createdVar = repository.getVariable(operand);
        } else
            createdVar = null;

        //if (Objects.isNull(createdVar)) {
        //    throw new CalcException("Incorrect variable");
        //}
        return createdVar;
    }
}
