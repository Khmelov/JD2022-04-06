package by.it.marchenko.jd02_01.utility;

import by.it.marchenko.jd02_01.exception.StoreException;

import static by.it.marchenko.jd02_01.constants.StoreExceptionConstant.*;

public class Delayer {


    public static final int SPEED_UP_COEFFICIENT = 10;

    public static void performDelay(int delay) {
        try {
            Thread.sleep(delay / SPEED_UP_COEFFICIENT);
        } catch (InterruptedException e) {
            throw new StoreException(INTERRUPTED_EXCEPTION_MESSAGE, e);
        }
    }
}
