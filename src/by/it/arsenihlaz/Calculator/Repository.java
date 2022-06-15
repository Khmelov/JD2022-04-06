package by.it.arsenihlaz.Calculator;

public interface Repository {

    Var save(String name, Var value);

    Var get(String name);
}
