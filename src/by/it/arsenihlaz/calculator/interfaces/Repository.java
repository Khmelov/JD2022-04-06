package by.it.arsenihlaz.calculator.interfaces;

import by.it.arsenihlaz.calculator.entity.Var;
import by.it.arsenihlaz.calculator.exception.CalcException;

public interface Repository {

    Var save(String name, Var value) throws CalcException;

    Var get(String name) throws CalcException;
}
