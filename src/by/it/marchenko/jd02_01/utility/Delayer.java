package by.it.marchenko.jd02_01.utility;

import by.it.marchenko.jd02_01.StoreException;

import static by.it.marchenko.jd02_01.StoreExceptionConstant.*;

public class Delayer {

    private final int delay = 2000;

    public static void performDelay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new StoreException(INTERRUPTED_EXCEPTION_MESSAGE, e);
        }
    }
}
