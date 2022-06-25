package by.it.arsenihlaz.calculator.services;

import by.it.arsenihlaz.calculator.constants.Exception;
import by.it.arsenihlaz.calculator.constants.Patterns;
import by.it.arsenihlaz.calculator.entity.Matrix;
import by.it.arsenihlaz.calculator.entity.Scalar;
import by.it.arsenihlaz.calculator.entity.Var;
import by.it.arsenihlaz.calculator.entity.Vector;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.interfaces.Repository;
import by.it.arsenihlaz.jd02_05.ResourceManager;

import java.util.Objects;

public class VarCreator {
    private final ResourceManager resourceManager = ResourceManager.INSTANSE;
    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String stringVar) throws CalcException {
        stringVar= stringVar.trim().replaceAll(Patterns.SPACES, "");
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
            throw new CalcException(resourceManager.getValue(Exception.INCORRECT_STRING) + " %s", stringVar);
        }
        return result;
    }
}
