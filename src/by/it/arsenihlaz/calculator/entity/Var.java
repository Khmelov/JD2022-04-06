package by.it.arsenihlaz.calculator.entity;

import by.it.arsenihlaz.calculator.constants.Message;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.interfaces.Operation;
import by.it.arsenihlaz.calculator.util.ResourceManager;

public abstract class Var implements Operation {
    private final ResourceManager resourceManager = ResourceManager.INSTANSE;


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Message.INCORRECT_OPERATION) + " %s + %s%n", this, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Message.INCORRECT_OPERATION) + " %s - %s%n", this, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Message.INCORRECT_OPERATION) + " %s * %s%n", this, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(resourceManager.getValue(Message.INCORRECT_OPERATION) + " %s / %s%n", this, other);
    }

    @Override
    public String toString() {
        return resourceManager.getValue(Message.UNKNOWN_VARIABLE);
    }
}
