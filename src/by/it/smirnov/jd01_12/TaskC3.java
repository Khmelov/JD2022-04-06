package by.it.smirnov.jd01_12;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(control(line));
    }

    private static boolean control(String line) {
        LinkedList<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile("[\\[\\{\\(\\]\\}\\)]");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group().equals("{") || matcher.group().equals("[") || matcher.group().equals("(")) list.addLast(matcher.group());
            else if(matcher.group().equals("}")) {
                if (list.isEmpty() || !(list.pollLast().equals("{" ))) return false;
            }
            else if(matcher.group().equals("]")) {
                if (list.isEmpty() || !(list.pollLast().equals("[" ))) return false;
            }
            else if(matcher.group().equals(")")) {
                if (list.isEmpty() || !(list.pollLast().equals("(" ))) return false;
            }
        }
        return true;
    }
}
