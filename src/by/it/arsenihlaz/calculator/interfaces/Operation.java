package by.it.arsenihlaz.calculator.interfaces;

import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.entity.Var;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}