package by.it.machuga.calc.interfaces;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;

public interface Operation {
    Var add(Var other) throws CalculatorException;

    Var sub(Var other) throws CalculatorException;

    Var mul(Var other) throws CalculatorException;

    Var div(Var other) throws CalculatorException;
}