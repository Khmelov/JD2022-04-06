package by.it.annazhegulovich.jd02_06_100.calc.interfaces;

import by.it.annazhegulovich.jd02_06_100.calc.entity.Var;
import by.it.annazhegulovich.jd02_06_100.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}