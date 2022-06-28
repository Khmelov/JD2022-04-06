package by.it.machuga.calc.servise;

import by.it.machuga.calc.entity.Matrix;
import by.it.machuga.calc.entity.Scalar;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.entity.Vector;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.interfaces.Message;
import by.it.machuga.calc.interfaces.VarCreator;
import by.it.machuga.calc.logger.Logger;
import by.it.machuga.calc.repasitory.Repository;

import java.util.Objects;

import static by.it.machuga.calc.constans.ConstantStorage.*;
import static by.it.machuga.calc.runner.ConsoleRunner.resourceManager;

public class VarBuilder implements VarCreator {
    private final Repository repository;
    private static Logger logger=Logger.INSTANCE;

    public VarBuilder(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String operand) throws CalculatorException {
        VarCreator varCreator;
        operand = operand.trim().replace(SPACE, EMPTY_STRING);
        if (operand.matches(SCALAR_REGEX)) {
            varCreator = new ScalarCreator();
        } else if (operand.matches(VECTOR_REGEX)) {
            varCreator = new VectorCreator();
        } else if (operand.matches(MATRIX_REGEX)) {
            varCreator = new MatrixCreator();
        } else {
            return getVarFromRepository(operand);
        }
        return varCreator.createVar(operand);
    }

    private Var getVarFromRepository(String operand) throws CalculatorException {
        Var var = repository.get(operand);
        if (Objects.isNull(var)) {
            logger.error(String.format(resourceManager.get(Message.INCORRECT_STRING_MSG), operand));
            throw new CalculatorException(String.format(resourceManager.get(Message.INCORRECT_STRING_MSG), operand));
        } else {
            return var;
        }
    }
}
