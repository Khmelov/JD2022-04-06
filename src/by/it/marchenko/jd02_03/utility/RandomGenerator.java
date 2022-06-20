package by.it.marchenko.jd02_03.utility;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public static final int DEFAULT_RANDOM_MIN = 0;

    public static int getRandom(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, ++maxValue);
    }

    public static int getRandom(int maxValue) {
        return getRandom(DEFAULT_RANDOM_MIN, maxValue);
    }
}
