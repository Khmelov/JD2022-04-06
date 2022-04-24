package by.it.ragach.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskА1 {
    public static void main(String[] args) {
       Pattern pattern = Pattern.compile ("[а-яА-яёЁ]+");
       Matcher matcher = pattern.matcher(Poem.text);

    }

}
