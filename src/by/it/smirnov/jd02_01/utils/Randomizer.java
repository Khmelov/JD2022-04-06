package by.it.smirnov.jd02_01.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    private Randomizer() {
    }

    public static int get(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }
}
