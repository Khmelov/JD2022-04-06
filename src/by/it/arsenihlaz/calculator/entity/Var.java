package by.it.arsenihlaz.calculator.entity;

import by.it.arsenihlaz.calculator.constants.Exception;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.interfaces.Operation;
import by.it.arsenihlaz.jd02_05.ResourceManager;

public abstract class Var implements Operation {
    private final ResourceManager resourceManager = ResourceManager.INSTANSE;


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Exception.INCORRECT_OPERATION) + " %s + %s%n", this, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Exception.INCORRECT_OPERATION) + " %s - %s%n", this, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Exception.INCORRECT_OPERATION) + " %s * %s%n", this, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Exception.INCORRECT_OPERATION) + " %s / %s%n", this, other);
    }

    @Override
    public String toString() {
        return resourceManager.getValue(Exception.UNKNOWN_VARIABLE);
    }
}
