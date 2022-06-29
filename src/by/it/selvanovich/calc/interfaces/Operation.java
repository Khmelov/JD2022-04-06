package by.it.selvanovich.calc.interfaces;

import by.it.selvanovich.calc.entity.Var;
import by.it.selvanovich.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;;

    Var sub(Var other) throws CalcException;;

    Var mul(Var other) throws CalcException;;

    Var div(Var other) throws CalcException;
}