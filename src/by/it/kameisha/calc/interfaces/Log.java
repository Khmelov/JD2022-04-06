package by.it.kameisha.calc.interfaces;

import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.exception.CalcException;

public interface Log {
    void error(CalcException e, String expression);

    void info(Var result, String expression);
}
