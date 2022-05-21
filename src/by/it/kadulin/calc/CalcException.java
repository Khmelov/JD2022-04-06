package by.it.kadulin.calc;

public class CalcException extends Exception{
    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(message);
    }

    public CalcException(String format, Object ... parameters) {
        this(String.format(format, parameters));
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
