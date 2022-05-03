package by.it.arsenihlaz.jd01_06;

import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {
        long startSlow = System.nanoTime();
        slow(Poem.text);
        long finishSlow = System.nanoTime();

        long startFast = System.nanoTime();
        fast(Poem.text);
        long finishFast = System.nanoTime();

        System.out.println("Slow time, ms = " + (finishSlow - startSlow) / 1000000);
        System.out.println("Fast time, ms = " + (finishFast - startFast) / 1000000);
    }

    static String slow(String text) {
        String randomSlowString = new String();
        String words[] = Poem.text.split("[^а-яА-ЯёЁ]+");
        Random random = new Random();
        while (randomSlowString.length() < 100000) {
            int wordIndex = (random.nextInt(words.length));
            randomSlowString = String.join(" ", randomSlowString, words[wordIndex]);
        }
        System.out.println(randomSlowString);
        System.out.println("Slow string length = " + randomSlowString.length());
        return text;
    }

    static String fast(String text) {
        StringBuilder randomFastString = new StringBuilder();
        String words[] = Poem.text.split("[^а-яА-ЯёЁ]+");
        Random random = new Random();
        while (randomFastString.length() < 100000) {
            int wordIndex = (random.nextInt(words.length));
            randomFastString = randomFastString.append(" " + words[wordIndex]);
        }
        System.out.println(randomFastString);
        System.out.println("Fast string length = " + randomFastString.length());
        return text;
    }
}
