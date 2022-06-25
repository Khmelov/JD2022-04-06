package by.it.eivanova.calc.interfaces;

import by.it._classwork_.calc.entity.Var;
import by.it._classwork_.calc.exception.CalcException;

public interface Repository {

    Var save(String name, Var value) throws CalcException;

    Var get(String name) throws CalcException;

}
