package by.it.machuga.jd02_01.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private RandomGenerator() {
    }

    public static int getRandomNumber(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }
    public  static int getRandomNumber(int max){
        return getRandomNumber(0,max);
    }

    public static String getRandomText(int size) {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append(ALPHABET.charAt(ThreadLocalRandom.current().nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
}
