package by.it.kudelko.calc.interfaces;

import by.it.kudelko.calc.entity.Var;
import by.it.kudelko.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}