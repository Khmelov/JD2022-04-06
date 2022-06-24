package by.it.annazhegulovich.calc.interfaces;

import by.it.annazhegulovich.calc.entity.Var;
import by.it.annazhegulovich.calc.exception.CalcException;

public interface Repository {
    Var save(String name, Var value) throws CalcException;
    Var get(String name) throws CalcException;
}
