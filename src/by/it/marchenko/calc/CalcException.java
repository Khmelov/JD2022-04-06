package by.it.marchenko.calc;

public class CalcException extends Exception {

    public CalcException(String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }
}
