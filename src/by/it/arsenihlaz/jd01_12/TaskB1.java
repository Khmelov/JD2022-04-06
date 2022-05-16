package by.it.arsenihlaz.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder textBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            if (text.equals("end")) {
                break;
            }
            textBuilder.append(text);
        }
        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        Pattern compile = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = compile.matcher(textBuilder.toString());
        while (matcher.find()) {
            String word = matcher.group();
            if (hashmap.containsKey(word)) {
                hashmap.put(word, hashmap.get(word) + 1);
            } else  {
                hashmap.put(word, 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = hashmap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

