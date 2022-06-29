package by.it.kameisha.calc.interfaces;

import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other)throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}