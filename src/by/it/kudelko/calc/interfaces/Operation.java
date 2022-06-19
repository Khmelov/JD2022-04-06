package by.it.kudelko.calc.interfaces;

import by.it.kudelko.calc.entity.Var;

public interface Operation {
    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other);
}