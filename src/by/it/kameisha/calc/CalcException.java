package by.it.kameisha.calc;

public class CalcException extends Exception {
    public CalcException(String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(String messsage, Object... parameters) {
        this(String.format(messsage, parameters));
    }
}
