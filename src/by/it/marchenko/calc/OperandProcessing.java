package by.it.marchenko.calc;

import java.util.ArrayList;

public interface OperandProcessing {
    ArrayList<String> createOperands(String expression) throws CalcException;

    ArrayList<String> createOperators(String expression);

}
