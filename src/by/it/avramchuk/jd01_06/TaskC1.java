package by.it.avramchuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

      String newText =  formatWidth(Poem.text);
        System.out.println(newText);
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

    private static String formatWidth(String sourceText) {
        String[] eachNewLine = sourceText.split("\\n");
        int max= findMaxLengt(eachNewLine);
        String newText = new String();

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
           newText = newText.concat(newStr) +"\n";
        }
        return newText;
    }
}
