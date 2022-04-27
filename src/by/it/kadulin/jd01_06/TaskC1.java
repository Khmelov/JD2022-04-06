package by.it.kadulin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    private static String[] str = {};

    public static void main(String[] args) {
//        long currentTimeMillis = System.currentTimeMillis();
        Pattern pattern = Pattern.compile("[^\\n]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            str = Arrays.copyOf(str, str.length + 1);
            str[str.length - 1] = matcher.group();
        }
        int maxLength = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > maxLength) {
                maxLength = str[i].length();
            }
        }
//        System.out.println(maxLength);
        for (int i = 0; i < str.length; i++) {
            str[i] = spaceAdd(str[i], maxLength);
            System.out.println(str[i]);
        }
//        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static String spaceAdd(String in, int maxLength) {
        String[] splitted = in.split(" ");
        for (int i = 0; i < splitted.length - 1; i++) {
            splitted[i] += " ";
            String strForCheck = "";
            for (int j = 0; j < splitted.length; j++) {
                strForCheck += splitted[j];
            }
            if (strForCheck.length() < maxLength) {
                if (i == splitted.length - 2) {
                    i = -1;
                }
            }
            else if (strForCheck.length() == maxLength) {
                break;
            }
        }
        String result = "";
        for (int i = 0; i < splitted.length; i++) {
            result += splitted[i];
        }
        return result;
    }
}
