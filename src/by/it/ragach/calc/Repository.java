package by.it.ragach.calc;

public interface Repository {

    Var save (String name, Var value) throws CalcException;

    Var get (String name) throws CalcException;
}
