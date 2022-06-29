package by.it.machuga.calc.servise;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.entity.Vector;
import by.it.machuga.calc.interfaces.VarCreator;

public class VectorCreator implements VarCreator {
    @Override
    public Var createVar(String operand) {
        return new Vector(operand);
    }
}
