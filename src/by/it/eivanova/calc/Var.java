package by.it.eivanova.calc;

public abstract class Var implements Operation {


    @Override
    public String toString() {
        return "abstract Var{}";
    }

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
