package by.it.kadulin.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static final int seed = 300;
    public static void main(String[] args) {

        long startSlow = System.nanoTime();
        String slowText = slow(Poem.text);
        System.out.println(slowText);
        System.out.printf("%s %d%n", "slow", (System.nanoTime() - startSlow) / 1_000_000);

        long startFast = System.nanoTime();
        String fastText = fast(Poem.text);
        System.out.println(fastText);
        System.out.printf("%s %d%n", "fast", (System.nanoTime() - startFast) / 1_000_000);
//        System.out.println(slowText.equals(fastText));
    }

    static String slow(String text) {
//        String[] words = poemToArray(text);
        String[] words = text.split("[^А-Яа-яЁё]+");
        String result = "";
        int length = 0;
        Random random = new Random(seed);
        while (result.length() < 100_000) {
            int indexWordArray = random.nextInt(words.length);
            result = result.concat(words[indexWordArray]).concat(" ");
//            length += result.length();
        }
        return result;
    }

    static String fast(String text) {
//        String[] words = poemToArray(text);
        String[] words = text.split("[^А-Яа-яЁё]+");
        StringBuilder sb = new StringBuilder();
        Random random = new Random(seed);
        int length = 0;
        while (sb.length() < 100_000) {
            int indexWordArray = random.nextInt(words.length);
            sb.append(words[indexWordArray]).append(" ");
//            length += sb.length();
        }
        return sb.toString();
    }

//    private static String[] poemToArray(String text) {
//        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
//        Matcher matcher = pattern.matcher(text);
//        String[] words = {};
//        while (matcher.find()) {
//            if (words.length != 0) {
//                boolean flag = false;
//                for (int i = 0; i < words.length; i++) {
//                    if (words[i].equals(matcher.group())) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag) {
//                    continue;
//                }
//            }
//            words = Arrays.copyOf(words, words.length + 1);
//            words[words.length - 1] = matcher.group();
//        }
//        return words;
//    }


}
