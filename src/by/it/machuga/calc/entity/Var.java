package by.it.machuga.calc.entity;

import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.interfaces.Message;
import by.it.machuga.calc.interfaces.Operation;
import by.it.machuga.calc.logger.Logger;

import static by.it.machuga.calc.runner.ConsoleRunner.resourceManager;

public abstract class Var implements Operation {
    public static Logger logger = Logger.INSTANCE;

    @Override
    public Var add(Var other) throws CalculatorException {
        logger.error(resourceManager.get(Message.CANNOT_ADD_MSG) + this
                + resourceManager.get(Message.AND) + other);
        throw new CalculatorException(resourceManager.get(Message.CANNOT_ADD_MSG) + this
                + resourceManager.get(Message.AND) + other);
    }

    @Override
    public Var sub(Var other) throws CalculatorException {
        logger.error(resourceManager.get(Message.CANNOT_SUBTRACT_MSG) + this
                + resourceManager.get(Message.AND) + other);
        throw new CalculatorException(resourceManager.get(Message.CANNOT_SUBTRACT_MSG) + this
                + resourceManager.get(Message.AND) + other);
    }

    @Override
    public Var mul(Var other) throws CalculatorException {
        logger.error(resourceManager.get(Message.CANNOT_MULTIPLY_MSG) + this
                + resourceManager.get(Message.AND) + other);
        throw new CalculatorException(resourceManager.get(Message.CANNOT_MULTIPLY_MSG) + this
                + resourceManager.get(Message.AND) + other);
    }

    @Override
    public Var div(Var other) throws CalculatorException {
        logger.error(resourceManager.get(Message.CANNOT_DIVIDE_MSG) + this
                + resourceManager.get(Message.BY) + other);
        throw new CalculatorException(resourceManager.get(Message.CANNOT_DIVIDE_MSG) + this
                + resourceManager.get(Message.BY) + other);
    }

    @Override
    public String toString() {
        return resourceManager.get(Message.UNKNOWN_VARIABLE_ABSTRACT_STUB_MSG);
    }
}
