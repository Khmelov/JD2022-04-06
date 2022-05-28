package by.it.avramchuk.calc;

public interface Repository {
    Var save(String name, Var value);

    Var get(String name);
}
