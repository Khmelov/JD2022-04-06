package by.it.smirnov.jd01_06;

import java.util.Arrays;

public class TaskB2 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("[.!]\\n");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[\\p{Punct}\\s]+", " ");
            words[i] = words[i].trim();
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                if(words[j].length() > words[j + 1].length()) {
                    String helper = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = helper;
                }
            }
        }
        for (String line:
             words) {
            System.out.println(line);
        }
    }
}
