package by.it.ragach.calc.interfaces;

import by.it.ragach.calc.entity.Var;
import by.it.ragach.calc.exception.CalcException;

public interface Repository {

    Var save (String name, Var value) throws CalcException;

    Var get (String name) throws CalcException;
}
