package by.it.arsenihlaz.Calculator.interfaces;

import by.it.arsenihlaz.Calculator.entity.Var;
import by.it.arsenihlaz.Calculator.exception.CalcException;

public interface Repository {

    Var save(String name, Var value) throws CalcException;

    Var get(String name) throws CalcException;
}
