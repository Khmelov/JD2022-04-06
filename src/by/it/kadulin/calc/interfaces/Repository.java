package by.it.kadulin.calc.interfaces;

import by.it.kadulin.calc.entity.Var;

public interface Repository {

    Var save(String name, Var value);

    Var get(String name);
}
