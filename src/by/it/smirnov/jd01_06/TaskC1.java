package by.it.smirnov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String sb = Poem.text;
        StringBuilder newText = new StringBuilder("");
        int longest = getLength();
        String[] poem = sb.split("\\n");
        for (int i = 0; i < poem.length; i++) {
            String line = formater(longest, poem[i]);
            newText.append(line).append("\n");
        }
        System.out.println(newText);
    }

    private static String formater(int longest, String line) {
        StringBuilder sb = new StringBuilder(line);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ\\p{Punct}]+");
        Matcher matcher = pattern.matcher(sb);
        int pos = 0;
        while (matcher.find(pos) && sb.length() < longest) {
            if (matcher.end() < sb.length() - 1) sb.insert(matcher.end(), " ");
            pos = matcher.end() + 1;
            if (matcher.end() == sb.length()) pos = 0;
        }
       return sb.toString();
    }

    private static int getLength() {
        Pattern pattern = Pattern.compile("[^\\n]+");
        Matcher matcher = pattern.matcher(Poem.text);
        int longest = 0;
        while (matcher.find()) {
            if (matcher.group().length() > longest) {
                longest = matcher.group().length();
            }
        }
        return longest;
    }

}
