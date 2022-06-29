package by.it.ragach.calc.interfaces;

import by.it.ragach.calc.entity.Var;
import by.it.ragach.calc.exception.CalcException;

public interface Operation {
    Var add(Var other)throws CalcException;

    Var sub(Var other)throws CalcException;

    Var mul(Var other)throws CalcException;

    Var div(Var other) throws CalcException;
}