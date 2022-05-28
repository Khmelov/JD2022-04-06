package by.it.marchenko.calc;

public interface CalcAppCommand {
    String performCommand(String command) throws CalcException;
}
