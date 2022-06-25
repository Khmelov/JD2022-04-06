package by.it.kudelko.calc.service;

import by.it.kudelko.calc.contants.Patterns;
import by.it.kudelko.calc.entity.Scalar;
import by.it.kudelko.calc.entity.Vector;
import by.it.kudelko.calc.entity.Matrix;
import by.it.kudelko.calc.entity.Var;
import by.it.kudelko.calc.interfaces.Repository;
import by.it.kudelko.calc.exception.CalcException;

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
            throw new CalcException("Incorrect String %s", stringVar);
        }
        return result;
    }
}
