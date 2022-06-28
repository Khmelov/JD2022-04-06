package by.it.annazhegulovich.jd02_06_b.calc.entity;


import by.it.annazhegulovich.jd02_06_b.calc.exception.CalcException;
import by.it.annazhegulovich.jd02_06_b.calc.interfaces.Operation;

public abstract class Var implements Operation {

    /*public static Var createVar(String stringVar) {
        Var result = null;
        if (stringVar.matches(Patterns.SCALAR)){
            result= new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)){
            result= new Vector(stringVar);
        }else if (stringVar.matches(Patterns.MATRIX)){
            result= new Matrix(stringVar);
        }

        return result;
    }*/

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Incorrect operation  %s + %s%n", this, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Incorrect operation  %s + %s%n", this, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Incorrect operation  %s + %s%n", this, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Incorrect operation  %s + %s%n", this, other);
    }

}
