package by.it.annazhegulovich.jd02_04.calc.service;

import by.it.annazhegulovich.jd02_04.calc.constans.Patterns;
import by.it.annazhegulovich.jd02_04.calc.entity.Matrix;
import by.it.annazhegulovich.jd02_04.calc.entity.Scalar;
import by.it.annazhegulovich.jd02_04.calc.entity.Var;
import by.it.annazhegulovich.jd02_04.calc.entity.Vector;
import by.it.annazhegulovich.jd02_04.calc.exception.CalcException;
import by.it.annazhegulovich.jd02_04.calc.interfaces.Repository;

import java.util.Objects;

public class VarCreator {

    private  final Repository repository;
    public VarCreator(Repository repository){
        this.repository = repository;
    }
    public Var createVar(String stringVar) throws CalcException {
        stringVar = stringVar.trim().replaceAll(Patterns.SPACES,"");
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
