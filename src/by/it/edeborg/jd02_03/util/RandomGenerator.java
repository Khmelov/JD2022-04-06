package by.it.edeborg.jd02_03.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int get(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    public static int get(int end) {
        return get(0, end);
    }
}
