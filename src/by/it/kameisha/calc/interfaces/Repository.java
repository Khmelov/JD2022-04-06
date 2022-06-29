package by.it.kameisha.calc.interfaces;

import by.it.kameisha.calc.entity.Var;

public interface Repository {
    
    Var save(String name, Var value);

    Var get(String name);
}
