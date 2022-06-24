package by.it.kudelko.calc.entity;

import by.it.kudelko.calc.interfaces.Operation;
import by.it.kudelko.calc.exception.CalcException;

public abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s + %s%n", this, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s - %s%n", this, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s * %s%n", this, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s / %s%n", this, other);
    }
}
