package by.it.kameisha.calc.exception;

public class CalcException extends Exception {
    public CalcException(String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(String message, Object... parameters) {
        this(String.format(message, parameters));
    }
}
