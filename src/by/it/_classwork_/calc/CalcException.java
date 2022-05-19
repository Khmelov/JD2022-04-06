package by.it._classwork_.calc;

public class CalcException extends Exception{


    public CalcException(String message) {
        super(message);
    }

    public CalcException(String format, Object... parameters) {
        this(String.format(format, parameters));
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }




}
