package by.it.marchenko.calc.interfaces;

import by.it.marchenko.calc.exception.CalcException;

public interface CalcAppCommand {
    String performCommand(String command) throws CalcException;
}
