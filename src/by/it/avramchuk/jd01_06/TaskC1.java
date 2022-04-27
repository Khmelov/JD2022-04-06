package by.it.avramchuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] eachNewLine = Poem.text.split("\\n");
        int max= findMaxLengt(eachNewLine);
       formatWidth(eachNewLine, max);
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

    private static void formatWidth(String[] eachNewLine, int max) {

        for (int i = 0; i < eachNewLine.length; i++) {
            StringBuilder str = new StringBuilder(eachNewLine[i]);
           while (str.length()<max){
               Pattern pattern = Pattern.compile("\s+");
               Matcher matcher = pattern.matcher(str);
               while (matcher.find()){
                   if (str.length()<max){
                       str = str.insert(matcher.start()+1, '#');
                   } else {break;}
               }
           }

           String newStr = str.toString();
           newStr = newStr.replace('#',' ');
            System.out.println(newStr);
        }
    }
}
