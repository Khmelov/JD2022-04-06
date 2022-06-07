package by.it.marchenko.jd02_02.exception;

public class StoreException extends RuntimeException {

    public static final String WAITING_IN_QUEUE_WAS_INTERRUPTED = "Waiting in queue was interrupted";

    @SuppressWarnings("unused")
    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
