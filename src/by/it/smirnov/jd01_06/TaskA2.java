package by.it.smirnov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] wordlist = {};
    private static int[] howmany = {};

    private static int pos(String word) {
        for (int i = 0; i < wordlist.length; i++) {
            if (wordlist[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();
            int i = pos(word);
            int count = 0;
            if (i >= 0) {
                howmany[i]++;
            } else {
                int last = wordlist.length;
                wordlist = Arrays.copyOf(wordlist, last + 1);
                wordlist[last] = word;
                howmany = Arrays.copyOf(howmany, last + 1);
                howmany[last] = 1;
            }
        }
        for (int i = 0; i < wordlist.length; i++) {
            System.out.println(wordlist[i] + "=" + howmany[i]);
        }
    }
}