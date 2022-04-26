package by.it.ragach.jd01_06;

import java.awt.geom.Ellipse2D;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static  String []symbols =  {"\n", "!", ",", ":", " -", "..."};


    public static void main(String[] args) {
        String text = Poem.text;


        for (int j = 0; j < symbols.length; j++) {
            if (j == 0) {
                text =text.replace(symbols[j], " ");
            }
            else if (j == 1) {
              text = text.replace(symbols[j], ".");
            }
            else {
              text= text.replace(symbols[j], "");
            }
        }


        String [] sentenses = text.split("[.]");
        for (int i = 0; i < sentenses.length; i++) {
           sentenses[i]= sentenses[i].trim();
            System.out.println(sentenses[i]);
        }


        Arrays.sort(sentenses, (o1, o2) -> o1.length() - o2.length());
        StringBuilder array = new StringBuilder();
        for (int i = 0; i < sentenses.length; i++) {
            array.append(sentenses[i]).append("\n");
        }
        System.out.print(array);
    }
}


