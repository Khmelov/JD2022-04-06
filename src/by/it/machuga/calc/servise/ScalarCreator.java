package by.it.machuga.calc.servise;

import by.it.machuga.calc.entity.Scalar;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.interfaces.VarCreator;

public class ScalarCreator implements VarCreator {
    @Override
    public Var createVar(String operand) {
        return new Scalar(operand);
    }
}
