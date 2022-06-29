package by.it.annazhegulovich.jd02_04.calc.interfaces;

import by.it.annazhegulovich.jd02_04.calc.entity.Var;
import by.it.annazhegulovich.jd02_04.calc.exception.CalcException;

public interface Repository {
    Var save(String name, Var value) throws CalcException;
    Var get(String name) throws CalcException;
}
