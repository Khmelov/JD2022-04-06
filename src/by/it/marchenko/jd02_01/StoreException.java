package by.it.marchenko.jd02_01;

public class StoreException extends RuntimeException {

    public StoreException(String message) {
        System.out.println(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
