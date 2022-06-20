package by.it.selvanovich.jd02_01;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int get(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    public static int get(int max) {
        return get(0, max);
    }

    public static Integer getInteger(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }
}
