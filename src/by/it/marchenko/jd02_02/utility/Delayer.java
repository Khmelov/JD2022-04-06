package by.it.marchenko.jd02_02.utility;

import by.it.marchenko.jd02_02.exception.StoreException;

import static by.it.marchenko.jd02_02.constants.StoreExceptionConstant.INTERRUPTED_EXCEPTION_MESSAGE;
import static by.it.marchenko.jd02_02.constants.UtilityConstant.*;

public class Delayer {
    private final double speedDownCoefficient;

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