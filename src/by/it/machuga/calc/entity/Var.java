package by.it.machuga.calc.entity;

import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.interfaces.Message;
import by.it.machuga.calc.interfaces.Operation;
import by.it.machuga.calc.logger.Logger;

import static by.it.machuga.calc.runner.ConsoleRunner.reporter;
import static by.it.machuga.calc.runner.ConsoleRunner.resourceManager;

public abstract class Var implements Operation {
    public static Logger logger = Logger.getInstance();

    @Override
    public Var add(Var other) throws CalculatorException {
        CalculatorException calculatorException = new CalculatorException(resourceManager.get(Message.CANNOT_ADD_MSG)
                + this + resourceManager.get(Message.AND) + other);
        logger.error(resourceManager.get(Message.CANNOT_ADD_MSG) + this
                + resourceManager.get(Message.AND) + other);
        reporter.collectReportError(ConstantStorage.OPERATION_ADD_FAILED, calculatorException);
        throw calculatorException;
    }

    @Override
    public Var sub(Var other) throws CalculatorException {
        CalculatorException calculatorException = new CalculatorException(resourceManager
                .get(Message.CANNOT_SUBTRACT_MSG) + this
                + resourceManager.get(Message.AND) + other);
        logger.error(resourceManager.get(Message.CANNOT_SUBTRACT_MSG) + this
                + resourceManager.get(Message.AND) + other);
        reporter.collectReportError(ConstantStorage.OPERATION_SUB_FAILED, calculatorException);
        throw calculatorException;
    }

    @Override
    public Var mul(Var other) throws CalculatorException {
        CalculatorException calculatorException = new CalculatorException(resourceManager
                .get(Message.CANNOT_MULTIPLY_MSG) + this
                + resourceManager.get(Message.AND) + other);
        logger.error(resourceManager.get(Message.CANNOT_MULTIPLY_MSG) + this
                + resourceManager.get(Message.AND) + other);
        reporter.collectReportError(ConstantStorage.OPERATION_MUL_FAILED, calculatorException);
        throw calculatorException;
    }

    @Override
    public Var div(Var other) throws CalculatorException {
        CalculatorException calculatorException = new CalculatorException(resourceManager.get(Message.CANNOT_DIVIDE_MSG)
                + this + resourceManager.get(Message.BY) + other);
        logger.error(resourceManager.get(Message.CANNOT_DIVIDE_MSG) + this
                + resourceManager.get(Message.BY) + other);
        reporter.collectReportError(ConstantStorage.OPERATION_DIV_FAILED, calculatorException);
        throw calculatorException;
    }

    @Override
    public String toString() {
        return resourceManager.get(Message.UNKNOWN_VARIABLE_ABSTRACT_STUB_MSG);
    }
}
