package by.it.kadulin.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static final String[] symbols = {"\n", "!", ",", ":", " -", "..."};

    public static void main(String[] args) {
        String poem = Poem.text;
        for (int j = 0; j < symbols.length; j++) {
            if (j == 0) {
                poem = poem.replace(symbols[j], " ");
            }
            else if (j == 1) {
                poem = poem.replace(symbols[j], ".");
            }
            else {
                poem = poem.replace(symbols[j], "");
            }
        }
        String[] array = poem.split("[.]");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
//            System.out.println("Index = " + i + " " + array[i]);
        }
        Arrays.sort(array, (o1, o2) -> o1.length() - o2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append("\n");
        }
        System.out.print(sb);
    }
}
