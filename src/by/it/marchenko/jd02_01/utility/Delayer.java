package by.it.marchenko.jd02_01.utility;

import by.it.marchenko.jd02_01.exception.StoreException;

import static by.it.marchenko.jd02_01.constants.StoreExceptionConstant.*;

public class Delayer {

    private final double speedDownCoefficient;

    public static final int TEST_SPEED_UP_COEFFICIENT = 50;
    public static final int NORMAL_MODE = 1;

    public Delayer(double speedDownCoefficient) {
        this.speedDownCoefficient = speedDownCoefficient;

    }

    public Delayer() {
        this(NORMAL_MODE);
    }


    public void performDelay(int delay) {
        try {
            Thread.sleep((int) (delay * speedDownCoefficient / TEST_SPEED_UP_COEFFICIENT));
        } catch (InterruptedException e) {
            throw new StoreException(INTERRUPTED_EXCEPTION_MESSAGE, e);
        }
    }

}
