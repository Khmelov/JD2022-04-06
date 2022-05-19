package by.it.arsenihlaz.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {
    private Object var;
    private static final Map<String, Var> vars = new HashMap<>();

    public static Var createVar(String stringVar) throws CalcException {
        Var result;
        if (stringVar.matches(Patterns.SCALAR)) {
            result = new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            result = new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)) {
            result = new Matrix(stringVar);
        } else {
            result = vars.get(stringVar);
        }
        if (Objects.isNull(result)) {
            throw new CalcException("Incorrect string %s", stringVar);
        }
        return result;
    }

    public static Var save(String name, Var value) {
        vars.put(name, value);

        return value;
    }

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
