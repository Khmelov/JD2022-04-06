package by.it.annazhegulovich.jd02_04.calc.interfaces;

import by.it.annazhegulovich.jd02_04.calc.entity.Var;
import by.it.annazhegulovich.jd02_04.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}