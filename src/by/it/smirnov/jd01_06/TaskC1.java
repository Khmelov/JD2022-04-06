package by.it.smirnov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        int longest = getLength();
        System.out.println(longest);
        sb = formater(longest, sb);

        System.out.println(sb);
    }

    private static StringBuilder formater(int longest, StringBuilder sb) {
        Pattern pattern = Pattern.compile("[^\\n]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String line = matcher.group().replaceFirst("\\s", "  ");

            /*
            String line = matcher.group();
            StringBuilder line1 = line;
            Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher1 = pattern1.matcher(line);
            while (matcher1.find() && matcher.group().length() < longest) {
                line.
            }

             */

        }
        return sb;

    }

    /*private static String doMagic (){
        while (matcher.group().length() < longest) {
            for (int i = 0; matcher.group().length() < longest; i++) {
                String space = " ".repeat(i + 1);
                int index = 0;
                while (index >= 0 && index < (matcher.group().length() - 1)) {
                    index = (matcher.group()).indexOf(space, index + 1);
                    sb.insert(index, " ");
        }

     */


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
