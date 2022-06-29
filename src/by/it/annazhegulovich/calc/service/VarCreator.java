package by.it.annazhegulovich.calc.service;

import by.it.annazhegulovich.calc.constans.Patterns;
import by.it.annazhegulovich.calc.entity.Matrix;
import by.it.annazhegulovich.calc.entity.Scalar;
import by.it.annazhegulovich.calc.entity.Var;
import by.it.annazhegulovich.calc.entity.Vector;
import by.it.annazhegulovich.calc.exception.CalcException;
import by.it.annazhegulovich.calc.interfaces.Repository;

import java.util.Objects;

public class VarCreator {

    private  final Repository repository;
    public VarCreator(Repository repository){
        this.repository = repository;
    }
    public Var createVar(String stringVar) throws CalcException {
        Var result;
        if(stringVar.matches(Patterns.SCALAR)){
            result = new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)){
            result = new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)){
            result = new Matrix(stringVar);
        }else {
            result = repository.get(stringVar);
        }
        if (Objects.isNull(result)){
            throw new CalcException("Incorrect string %s", stringVar);
        }
        return result;
    }
}
