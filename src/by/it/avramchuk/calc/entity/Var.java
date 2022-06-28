package by.it.avramchuk.calc.entity;

import by.it.avramchuk.calc.constants.Message;
import by.it.avramchuk.calc.exception.CalcException;
import by.it.avramchuk.calc.interfaces.Operation;
import by.it.avramchuk.calc.util.ResMan;

public abstract class Var implements Operation {
    ResMan resMan= ResMan.INSTANCE;

    @Override
    public String toString() {
        return "Var{}";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(resMan.get(Message.INCORRECT_OPER_MESSAGE)+ " %s + %s", this, other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException(resMan.get(Message.INCORRECT_OPER_MESSAGE)+ " %s - %s", this, other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(resMan.get(Message.INCORRECT_OPER_MESSAGE)+ " %s * %s", this, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(resMan.get(Message.INCORRECT_OPER_MESSAGE)+ " %s / %s", this, other);
    }
}
