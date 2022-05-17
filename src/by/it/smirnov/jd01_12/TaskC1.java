package by.it.smirnov.jd01_12;

import java.math.BigInteger;
import java.rmi.server.UID;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.UUID.randomUUID;

public class TaskC1 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        fillByScanner(sb);
        Map<String, String> words = sortCalc(sb);
        System.out.println(words.toString());
        Map<String, String> squeezed = squeeze(words);
        System.out.println(squeezed.toString());
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

    private static String keyGenerate() {
        return String.valueOf((int)( Math.random() * ((100000000 - 1) + 1)) + 1);
    }

    private static Map<String, String> sortCalc(StringBuilder sb) {
        Map<String, String> words = new TreeMap<>();
        Pattern pattern = Pattern.compile("[\\w\']+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            words.put(keyGenerate(), matcher.group());
        }
        return words;
    }

    private static Map<String, String> squeeze(Map<String, String> words) {
        Map<String, String> squeezed = new TreeMap<>();
        words.forEach((key, value) -> {
            if (!squeezed.containsValue(value)) squeezed.put(key, value);
        });
        return squeezed;
    }
}
