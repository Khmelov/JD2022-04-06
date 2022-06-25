package by.it.kudelko.calc.interfaces;

import by.it.kudelko.calc.entity.Var;
import by.it.kudelko.calc.exception.CalcException;

public interface Repository {

    Var save(String name, Var value) throws CalcException;

    Var get(String name) throws CalcException;

}
