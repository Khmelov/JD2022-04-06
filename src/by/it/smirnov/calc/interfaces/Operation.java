package by.it.smirnov.calc.interfaces;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;
    Var sub(Var other) throws CalcException;
    Var mul(Var other) throws CalcException;
    Var div(Var other) throws CalcException;
}
