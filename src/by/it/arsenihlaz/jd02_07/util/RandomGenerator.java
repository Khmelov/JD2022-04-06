package by.it.arsenihlaz.jd02_07.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int get(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    public static boolean getBoolean() {
        return Math.random() < 0.5;
    }
}
