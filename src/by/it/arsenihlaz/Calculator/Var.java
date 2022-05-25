package by.it.arsenihlaz.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {
    private Object var;


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s + %s%n", this, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s + %s%n", this, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s + %s%n", this, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Incorrect operation %s + %s%n", this, other);
    }

    @Override
    public String toString() {
        return "unknown variable";
    }
}
