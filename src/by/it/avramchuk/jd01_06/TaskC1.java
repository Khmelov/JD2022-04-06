package by.it.avramchuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String strB = Poem.text;
        StringBuilder newText = new StringBuilder("");
        String[] eachNewLine = strB.split("\\n");
        int max = findMaxLengt(eachNewLine);
        for (int i = 0; i < eachNewLine.length; i++) {
            String line = formatWidth(max, eachNewLine[i]);
            newText.append(line).append("\n");
        }
        System.out.println(newText);
    }

    private static String formatWidth(int max, String line) {
        StringBuilder strB = new StringBuilder(line);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ\\p{Punct}]+");
        Matcher matcher = pattern.matcher(strB);
        int position = 0;
        while (matcher.find(position) && strB.length() < max) {
            if (matcher.end() < strB.length() - 1) strB.insert(matcher.end(), " ");
            position = matcher.end() + 1;
            if (matcher.end() == strB.length()) position = 0;
        }
        return strB.toString();
    }

    private static int findMaxLengt(String[] eachNewLine) {
        int max = 0;
        for (String s : eachNewLine) {
            if (s.length()>max){
                max = s.length();
            }
        }
        return max;
    }

}