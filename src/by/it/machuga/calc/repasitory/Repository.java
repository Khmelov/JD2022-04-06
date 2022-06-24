package by.it.machuga.calc.repasitory;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;

public interface Repository {

    Var save(String name, Var value) throws CalculatorException;

    Var get(String name) throws CalculatorException;

}

