package by.it.machuga.jd02_02.util;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int getRandomInt(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    public static int getRandomInt(int max) {
        return getRandomInt(0, max);
    }

    public static String getRandomText(int size) {
        StringBuilder sb = new StringBuilder(size);
        sb.append(Constants.ALPHABET_UPPERCASE.charAt(getRandomInt(Constants.ALPHABET_UPPERCASE.length() - 1)));
        for (int i = 0; i < size - 1; i++) {
            sb.append(Constants.ALPHABET_LOWERCASE.charAt(getRandomInt(Constants.ALPHABET_LOWERCASE.length() - 1)));
        }
        return sb.toString();
    }

    public static double getRandomDouble(double start, double end) {
        return ThreadLocalRandom.current().nextDouble(start, end + 1);
    }
}
