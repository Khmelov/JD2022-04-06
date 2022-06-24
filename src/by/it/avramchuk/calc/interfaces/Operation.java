package by.it.avramchuk.calc.interfaces;

import by.it.avramchuk.calc.exception.CalcException;
import by.it.avramchuk.calc.entity.Var;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}
