package by.it.smirnov.calc.interfaces;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;

public interface Repository {
    Var saveVar(String name, Var var) throws CalcException;

    Var get(String name) throws CalcException;
}
