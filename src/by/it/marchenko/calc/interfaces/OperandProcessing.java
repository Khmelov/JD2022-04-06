package by.it.marchenko.calc.interfaces;

import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.entity.Var;

import java.util.List;

public interface OperandProcessing {
    List<String> createOperands(String expression) throws CalcException;

    List<String> createOperators(String expression);

    Var createVar(String operand) throws CalcException;

    List<Var> createVar(List<String> operands) throws CalcException;
}
