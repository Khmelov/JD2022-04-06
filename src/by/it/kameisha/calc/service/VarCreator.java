package by.it.kameisha.calc.service;

import by.it.kameisha.calc.constants.Errors;
import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.constants.Patterns;
import by.it.kameisha.calc.entity.Matrix;
import by.it.kameisha.calc.entity.Scalar;
import by.it.kameisha.calc.entity.Vector;
import by.it.kameisha.calc.exception.CalcException;
import by.it.kameisha.calc.interfaces.Repository;

import java.util.Objects;

public class VarCreator {
    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String stringVar) throws CalcException {
        Var result;
        stringVar = stringVar.trim().replace(" ","");
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
            throw new CalcException(Errors.INCORRECT_STRING +" %s", stringVar);
        }
        return result;
    }

}
