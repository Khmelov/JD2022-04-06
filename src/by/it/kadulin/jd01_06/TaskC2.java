package by.it.kadulin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    private static String[] words = {};
    private static String[] arrayForTest = {};

    public static void main(String[] args) {
        arraysPrepare();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < arrayForTest.length; i++) {
//            stringBuilder.append(arrayForTest[i]).append(" ");
//        }
        long startSlow = System.nanoTime();
        String slowText = "";
        for (int i = 0; i < arrayForTest.length; i++) {
            slowText = slowText.concat(slow(arrayForTest[i]));
        }
        System.out.println(slowText);
        System.out.printf("%s %d%n", "slow", (System.nanoTime() - startSlow) / 1_000_000);

        long startFast = System.nanoTime();
        String fastText = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayForTest.length; i++) {
            sb.append(fast(arrayForTest[i]));
        }
        fastText = sb.toString();
        System.out.println(fastText);
        System.out.printf("%s %d%n", "fast", (System.nanoTime() - startFast) / 1_000_000);

//        long startSlow = System.nanoTime();
//        String slowText = slow(stringBuilder.toString().trim());
//        System.out.printf("%s %d%n", "slow", (System.nanoTime() - startSlow) / 1_000_000);
//        long startFast = System.nanoTime();
//        String fastText = fast(stringBuilder.toString().trim());
//        System.out.printf("%s %d%n", "fast", (System.nanoTime() - startFast) / 1_000_000);
    }

//    static String slow(String text) {
//        String[] array = text.split(" ");
//        String resultConcatText = "";
//        for (int i = 0; i < array.length; i++) {
//            resultConcatText = resultConcatText.concat(array[i]).concat(" ");
//        }
//        return resultConcatText;
//    }

    static String slow(String text) {
        return text.concat(" ");
    }

//    static String fast(String text) {
//        String[] array = text.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < array.length; i++) {
//            sb.append(array[i]).append(" ");
//        }
//        return sb.toString();
//    }

    static String fast(String text) {
        StringBuilder sb = new StringBuilder(text);
        return sb.append(" ").toString();
    }

    private static void arraysPrepare() {
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = matcher.group();
        }
        int length = 0;
        while (length < 100_000) {
            int indexWordArray = (int) (Math.random() * words.length);
            arrayForTest = Arrays.copyOf(arrayForTest, arrayForTest.length + 1);
            arrayForTest[arrayForTest.length - 1] = words[indexWordArray];
            length += words[indexWordArray].length();
        }
    }
}
