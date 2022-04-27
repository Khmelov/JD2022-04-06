package by.it.kameisha.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB2 {
    public static void main(String[] args) {
        Pattern pattern1 = Pattern.compile("[.]{2,}");
        Matcher matcher1 = pattern1.matcher(Poem.text);
        String newPoem = matcher1.replaceAll(" ");
        Pattern pattern2 = Pattern.compile("[^а-яА-ЯёЁ.!]+");
        Matcher matcher2 = pattern2.matcher(newPoem);
        newPoem = matcher2.replaceAll(" ");
        newPoem = newPoem.replaceAll("!", ".");
        String[] stringsPoem = newPoem.trim().split("\\. ");
        sortStringArray(stringsPoem);
        printStringArray(stringsPoem);

    }

    private static void sortStringArray(String[] stringsPoem) {
        for (int i = 0; i < stringsPoem.length; i++) {
            int minLength = stringsPoem[i].length();
            int minLengthIndex = i;
            for (int j = i; j < stringsPoem.length; j++) {
                if (minLength > stringsPoem[j].length()) {
                    minLength = stringsPoem[j].length();
                    minLengthIndex = j;
                }
            }
            if (minLengthIndex != i) {
                String temporary = stringsPoem[i];
                stringsPoem[i] = stringsPoem[minLengthIndex];
                stringsPoem[minLengthIndex] = temporary;
            }
        }
    }

    private static void printStringArray(String[] stringsPoem) {
        for (String strings : stringsPoem) {
            System.out.println(strings);
        }
    }
}

