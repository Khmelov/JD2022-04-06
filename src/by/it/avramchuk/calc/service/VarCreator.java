package by.it.avramchuk.calc.service;
import by.it.avramchuk.calc.exception.CalcException;

import by.it.avramchuk.calc.constants.Patterns;
import by.it.avramchuk.calc.entity.Matrix;
import by.it.avramchuk.calc.entity.Scalar;
import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.entity.Vector;
import by.it.avramchuk.calc.interfaces.Repository;

import java.util.Objects;

public class VarCreator {

    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String stringVar) throws CalcException {
        stringVar= stringVar.trim().replaceAll(Patterns.SPACES, "");
        Var result ;
        if (stringVar.matches(Patterns.SCALAR)){
            result =  new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)){
            result =  new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)){
            result =  new Matrix(stringVar);
        } else {
            result=repository.get(stringVar);
        }
        if (Objects.isNull(result)){
            throw new CalcException("Incorrect string %s", stringVar);
        }
        return  result;
    }
}
