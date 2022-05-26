package by.it._classwork_.calc.interfaces;

import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.entity.Var;

public interface Operation {
    Var add(Var other) throws CalcException;;

    Var sub(Var other) throws CalcException;;

    Var mul(Var other) throws CalcException;;

    Var div(Var other) throws CalcException;
}