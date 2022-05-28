package by.it.selvanovich.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {

    public static void main(String[] args) {
        String text = fillString();
        Map<String, Integer> words = new HashMap<>();
        countFreq(text, words);
        System.out.println(words);
    }

    public static String fillString() {
        StringBuilder textBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (!value.equals("end")) {
                textBuilder.append(value).append(" ");
            } else {
                break;
            }
        }
        return textBuilder.toString();
    }

    private static void countFreq(String text, Map<String, Integer> words) {
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
    }
}

