package by.it.annazhegulovich.jd02_06_b.calc.interfaces;

import by.it.annazhegulovich.jd02_06_b.calc.entity.Var;
import by.it.annazhegulovich.jd02_06_b.calc.exception.CalcException;

public interface Repository {
    Var save(String name, Var value) throws CalcException;
    Var get(String name) throws CalcException;
}
