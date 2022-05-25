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
        String tempOperand = operand.replaceAll(SPACES_REGEX,EMPTY_STRING);
        if (operand.matches(SCALAR_PATTERN)) {
            //            createdVar = new Scalar(operand);
            createdVar = new Scalar(tempOperand);
        } else if (operand.matches(VECTOR_PATTERN)) {
            //createdVar = new Vector(operand);
            createdVar = new Vector(tempOperand);
        } else if (operand.matches(MATRIX_PATTERN)) {
            //createdVar = new Matrix(operand);
            createdVar = new Matrix(tempOperand);
        } else if (repository.getAllVariables().containsKey(operand)) {
            createdVar = repository.getVariable(operand);
        } else
            createdVar = null;
        //TODO throw CalcException. Change assignment algorithm...

        //if (Objects.isNull(createdVar)) {
        //    throw new CalcException("Incorrect variable");
        //}
        return createdVar;
    }
}
