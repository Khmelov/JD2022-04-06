package by.it.marchenko.jd02_01.exception;

public class StoreException extends RuntimeException {

    @SuppressWarnings("unused")
    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
