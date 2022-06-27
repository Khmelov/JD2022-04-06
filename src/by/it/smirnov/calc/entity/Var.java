package by.it.smirnov.calc.entity;

import by.it.smirnov.calc.constants.Patterns;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Operation;

import static by.it.smirnov.calc.constants.Wordings.*;
import static by.it.smirnov.calc.service.ResManager.INSTANCE;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return INSTANCE.getString(VAR_UNKNOWN);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.ADD, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.SUB, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.MUL, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.DIV, other);
    }
}
