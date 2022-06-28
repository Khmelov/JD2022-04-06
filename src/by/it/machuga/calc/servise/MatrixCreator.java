package by.it.machuga.calc.servise;

import by.it.machuga.calc.entity.Matrix;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.interfaces.VarCreator;

public class MatrixCreator implements VarCreator {
    @Override
    public Var createVar(String operand) {
        return new Matrix(operand);
    }
}
