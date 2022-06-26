package by.it.machuga.calc.servise;

import by.it.machuga.calc.entity.Matrix;
import by.it.machuga.calc.entity.Scalar;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.entity.Vector;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.repasitory.Repository;

import java.util.Objects;

import static by.it.machuga.calc.constans.ConstantStorage.*;

public class VarCreator {
    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String operand) throws CalculatorException {
        Var result;
        operand = operand.trim().replace(SPACE, EMPTY_STRING);
        if (operand.matches(SCALAR_REGEX)) {
            result = new Scalar(operand);
        } else if (operand.matches(VECTOR_REGEX)) {
            result = new Vector(operand);
        } else if (operand.matches(MATRIX_REGEX)) {
            result = new Matrix(operand);
        } else {
            result = repository.get(operand);
        }
        if (Objects.isNull(result)) {
            throw new CalculatorException(String.format(INCORRECT_STRING_MSG, operand));
        }
        return result;
    }
}
