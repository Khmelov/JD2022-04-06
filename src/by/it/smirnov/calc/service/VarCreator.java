package by.it.smirnov.calc.service;

import by.it.smirnov.calc.constants.Patterns;
import by.it.smirnov.calc.entity.Matrix;
import by.it.smirnov.calc.entity.Scalar;
import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.entity.Vector;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;

import java.util.Objects;

import static by.it.smirnov.calc.constants.Wordings.BAD_STRING;

public class VarCreator {

    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String operand) throws CalcException {
        Var result;
        Parser parser = new Parser(repository, new VarCreator(repository));
        operand = parser.deBrace(operand);
        if (operand.matches(Patterns.SCALAR)) result = new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR)) result = new Vector(operand);
        else if (operand.matches(Patterns.MATRIX)) result = new Matrix(operand);
        else result = repository.get(operand);
        if (Objects.isNull(result)) {
            throw new CalcException(BAD_STRING, operand);
        }
        return result;
    }
}
