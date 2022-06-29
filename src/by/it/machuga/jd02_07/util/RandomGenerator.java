package by.it.machuga.jd02_07.util;

import by.it.machuga.jd02_07.interfaces.Constants;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int getRandomInt(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    public static String getRandomText(int size) {
        StringBuilder sb = new StringBuilder(size);
        sb.append(Constants.ALPHABET_UPPERCASE.charAt(getRandomInt(0, Constants.ALPHABET_UPPERCASE.length() - 1)));
        for (int i = 0; i < size - 1; i++) {
            sb.append(Constants.ALPHABET_LOWERCASE.charAt(getRandomInt(0, Constants.ALPHABET_LOWERCASE.length() - 1)));
        }
        return sb.toString();
    }

    public static boolean getRandomBoolean() {
        return getRandomInt(1, 10) > 5;
    }
}