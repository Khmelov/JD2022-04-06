package by.it.avramchuk.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private  static final Map<String,Var> vars = new HashMap<>();

    public static Var createVar(String stringVar) {
        Var result ;
        if (stringVar.matches(Patterns.SCALAR)){
            result =  new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)){
            result =  new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)){
            result =  new Matrix(stringVar);
        } else {
            result=vars.get(stringVar);
        }
        return  result;
    }

    public static Var save(String name, Var value) {
        vars.put(name, value);
        return value;
    }

    @Override
    public String toString() {
        return "Var{}";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Incorrect operation %s + %s%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Incorrect operation %s - %s%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Incorrect operation %s * %s%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Incorrect operation %s / %s%n", this, other);
        return null;
    }
}
