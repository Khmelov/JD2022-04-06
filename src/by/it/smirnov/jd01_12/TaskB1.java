package by.it.smirnov.jd01_12;

import by.it.smirnov.jd01_09.Parser;
import by.it.smirnov.jd01_09.Patterns;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        fillByScanner(sb);
        Map<String, Integer> words = sortCalc(sb);
        System.out.println(words.toString());
    }

    private static void fillByScanner(StringBuilder sb) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equals("end")) break;
            sb.append(line).append(" ");
        }
    }

    private static Map<String, Integer> sortCalc(StringBuilder sb) {
        Map<String, Integer> words = new HashMap<>();
        Pattern pattern = Pattern.compile("[\\w\']+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            if (!words.containsKey(matcher.group())) {
                words.put(matcher.group(), 1);
            } else if (words.containsKey(matcher.group()))
                words.merge(matcher.group(), 1, Integer::sum);
        } return words;
    }
}