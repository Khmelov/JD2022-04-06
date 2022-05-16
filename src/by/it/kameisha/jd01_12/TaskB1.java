package by.it.kameisha.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        while (scanner.hasNext()) {
            String input = scanner.next();
            Matcher matcher = pattern.matcher(input);
            if (!input.equals("end")) {
                while (matcher.find()) {
                    String word = matcher.group();
                    text.add(word);
                }
            } else {
                break;
            }
        }
        Map<String, Integer> mapText = new HashMap<>();
        for (String string : text) {
            if (!mapText.containsKey(string)) {
                mapText.put(string, 0);
            } else {
                mapText.put(string, mapText.get(string) + 1);
            }
        }
        System.out.println(mapText);
    }

}
