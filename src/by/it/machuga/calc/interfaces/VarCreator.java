package by.it.machuga.calc.interfaces;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;

public interface VarCreator {
    Var createVar(String operand) throws CalculatorException;
}
