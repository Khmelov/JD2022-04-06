package by.it.machuga.calc.entity;

import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.interfaces.Operation;

public abstract class Var implements Operation {


    @Override
    public Var add(Var other)throws CalculatorException {
       throw new CalculatorException(ConstantStorage.CANNOT_ADD_MSG + this + ConstantStorage.AND + other);
    }

    @Override
    public Var sub(Var other)throws CalculatorException {
        throw new CalculatorException(ConstantStorage.CANNOT_SUBTRACT_MSG + this + ConstantStorage.AND + other);
    }

    @Override
    public Var mul(Var other)throws CalculatorException {
        throw new CalculatorException(ConstantStorage.CANNOT_MULTIPLY_MSG + this + ConstantStorage.AND + other);
    }

    @Override
    public Var div(Var other)throws CalculatorException{
        throw new CalculatorException(ConstantStorage.CANNOT_DIVIDE_MSG + this + ConstantStorage.BY + other);
    }

    @Override
    public String toString() {
        return ConstantStorage.UNKNOWN_VARIABLE_ABSTRACT_STUB_MSG;
    }
}
