package by.it.smirnov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        list.add(1, "fourteen");
        System.out.println(list);
        String line = list.toString();
        System.out.println(line);
        System.out.printf("First = %s, Last = %s", list.get(0), list.get(list.size() - 1));
        System.out.println();
        System.out.println();

        list = new ListB<>();
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("eleven");
        System.out.println(list);
        list.remove(2);
        list.add(1, "fourteen");
        System.out.println(list);

        System.out.println(list.toString());
        System.out.printf("First = %s, Last = %s", list.get(0), list.get(list.size() - 1));
    }
}
