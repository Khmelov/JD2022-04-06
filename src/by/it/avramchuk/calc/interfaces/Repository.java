package by.it.avramchuk.calc.interfaces;

import by.it._classwork_.calc.exception.CalcException;
import by.it.avramchuk.calc.entity.Var;

public interface Repository {
    Var save(String name, Var value) throws CalcException;

    Var get(String name)throws CalcException;
}
