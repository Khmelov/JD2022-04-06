package by.it.kadulin.calc.service;

import by.it._classwork_.calc.exception.CalcException;
import by.it.kadulin.calc.constans.Patterns;
import by.it.kadulin.calc.entity.*;
import by.it.kadulin.calc.interfaces.Repository;

import java.util.Objects;

public class VarCreator {

    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String stringVar) {
        Var result;
        if (stringVar.matches(Patterns.SCALAR)) {
            result = new Scalar(stringVar);
        }
        else if (stringVar.matches(Patterns.VECTOR)) {
            result = new Vector(stringVar);
        }
        else if (stringVar.matches(Patterns.MATRIX)) {
            result = new Matrix(stringVar);
        }
        else {
            result = repository.get(stringVar);
        }
//        if (Objects.isNull(result)) {
//            System.out.println("Incorrect string %s");
//        }
        return result;
    }
}
