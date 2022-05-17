package by.it.kameisha.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> text = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Integer index = 0;
        while (scanner.hasNext()) {
            String input = scanner.next();
            Matcher matcher = pattern.matcher(input);
            if (!input.equals("end")) {
                while (matcher.find()) {
                    String word = matcher.group();
                    text.put(index, word);
                    index++;
                }
            } else {
                break;
            }
        }
        System.out.println(text.toString());
        Map<Integer, String> textFixed = new HashMap<>();
        Iterator<Map.Entry<Integer, String>> iterator = text.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,String> element = iterator.next();
            if (!textFixed.containsValue(element.getValue())) {
                textFixed.put(element.getKey(), element.getValue());
            }
        }
        System.out.println(textFixed.toString());
    }
}
