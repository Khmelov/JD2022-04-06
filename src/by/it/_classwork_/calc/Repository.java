package by.it._classwork_.calc;

public interface Repository {

    Var save(String name, Var value);

    Var get(String name);

}
