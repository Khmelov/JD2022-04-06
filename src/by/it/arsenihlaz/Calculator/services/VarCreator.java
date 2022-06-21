package by.it.arsenihlaz.Calculator.services;

import by.it.arsenihlaz.Calculator.constants.Patterns;
import by.it.arsenihlaz.Calculator.entity.Matrix;
import by.it.arsenihlaz.Calculator.entity.Scalar;
import by.it.arsenihlaz.Calculator.entity.Var;
import by.it.arsenihlaz.Calculator.entity.Vector;
import by.it.arsenihlaz.Calculator.exception.CalcException;
import by.it.arsenihlaz.Calculator.interfaces.Repository;

import java.util.Objects;

public class VarCreator {

    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String stringVar) throws CalcException {
        Var result;
        if (stringVar.matches(Patterns.SCALAR)) {
            result = new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            result = new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)) {
            result = new Matrix(stringVar);
        } else {
            result = repository.get(stringVar);
        }
        if (Objects.isNull(result)) {
            throw new CalcException("Incorrect string %s", stringVar);
        }
        return result;
    }
}
