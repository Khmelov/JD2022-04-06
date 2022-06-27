package by.it.marchenko.calc.services;

import by.it.marchenko.calc.entity.Matrix;
import by.it.marchenko.calc.entity.Scalar;
import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.entity.Vector;
import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.interfaces.Repository;

import java.util.Objects;

import static by.it.marchenko.calc.constant.MessageConst.*;

public class VarCreator {
    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String operand) throws CalcException {
        Var createdVar = null;
        if (operand.matches(SCALAR_PATTERN)) {
            createdVar = new Scalar(operand);
        } else if (operand.matches(VECTOR_PATTERN)) {
            createdVar = new Vector(operand);
        } else if (operand.matches(MATRIX_PATTERN)) {
            createdVar = new Matrix(operand);
        } else if (repository.getAllVariables().containsKey(operand)) {
            createdVar = repository.getVariable(operand);
        }
        if (Objects.isNull(createdVar)) {
            throw new CalcException(
                    INPUT_EXCEPTION + WRONG_OPERAND_EXCEPTION + WRONG_OPERAND_COMMENT, operand);
        }
        return createdVar;
    }
}