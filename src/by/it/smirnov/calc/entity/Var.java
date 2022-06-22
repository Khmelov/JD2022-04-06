package by.it.smirnov.calc.entity;

import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Operation;

import static by.it.smirnov.calc.constants.Wordings.*;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return VAR_UNKNOWN;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(BAD_OPER, this, ADD, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(BAD_OPER, this, SUB, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(BAD_OPER, this, MUL, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(BAD_OPER, this, DIV, other);
    }
}
