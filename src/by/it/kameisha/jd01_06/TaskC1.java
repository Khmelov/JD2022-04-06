package by.it.kameisha.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static String poem = Poem.text;
    private static Pattern pattern = Pattern.compile("[ ]+");

    public static void main(String[] args) {

        String[] poemStrings = poem.split("\n");
        processPoem(poemStrings);
    }

    private static void processPoem(String[] poemStrings) {
        int maxStringLength = 0;
        int[] poemStringsLength = new int[poemStrings.length];
        for (int i = 0; i < poemStrings.length; i++) {
            poemStringsLength[i] = poemStrings[i].length();
            if (maxStringLength < poemStrings[i].length()) {
                maxStringLength = poemStrings[i].length();
            }
        }

    }
}
