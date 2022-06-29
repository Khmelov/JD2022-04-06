package by.it.selvanovich.calc.interfaces;

import by.it.selvanovich.calc.entity.Var;
import by.it.selvanovich.calc.exception.CalcException;

public interface Repository {

    Var save(String name, Var value) throws CalcException;

    Var get(String name) throws CalcException;

}
