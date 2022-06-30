package by.it.kameisha.jd02_07.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static final int MIN_NAME_LENGTH = 5;
    public static final int MAX_NAME_LENGTH = 10;

    private RandomGenerator() {
    }

    public static Integer getRandomAge(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static boolean getRandomActive() {
        int random = ThreadLocalRandom.current().nextInt();
        return random < 0.5;
    }

    public static String getRandomName() {
        String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        int nameLength = ThreadLocalRandom.current().nextInt(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        StringBuilder sb = new StringBuilder(nameLength);
        for (int i = 0; i < nameLength; i++) {
            int index = (int) (AlphaString.length() * Math.random());
            sb.append(AlphaString.charAt(index));
        }
        return sb.toString();
    }
}
