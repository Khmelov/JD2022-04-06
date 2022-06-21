package by.it.arsenihlaz.Calculator.interfaces;

import by.it.arsenihlaz.Calculator.exception.CalcException;
import by.it.arsenihlaz.Calculator.entity.Var;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}