package by.it.selvanovich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one"); //0
        list.add("two"); //1
        list.add("three"); //2
        list.add("four"); //3
        list.add("five"); //
        System.out.println(list);
        list.remove(2);
        list.set(1, "2");
        System.out.println(list);
        System.out.printf("first=%s last=%s%n", list.get(0), list.get(list.size() - 1));
        list.add(2, "3");
        System.out.println(list);
        list.addAll(list);
        System.out.println(list);

        list = new ListA<>();
        list.add("one"); //0
        list.add("two"); //1
        list.add("three"); //2
        list.add("four"); //3
        list.add("five"); //
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.printf("first=%s last=%s%n%n", list.get(0), list.get(list.size() - 1));

        list = new ListB<>();
        list.add("one"); //0
        list.add("two"); //1
        list.add("three"); //2
        list.add("four"); //3
        list.add("five"); //
        System.out.println(list);
        list.remove(2);
        list.set(1, "2");
        System.out.println(list);
        System.out.printf("first=%s last=%s%n", list.get(0), list.get(list.size() - 1));
        list.add(2, "3");
        System.out.println(list);
        list.addAll(list);
        System.out.println(list);
    }
}
