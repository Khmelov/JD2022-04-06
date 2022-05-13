package by.it.kameisha.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        list1.add("five");
        System.out.println(list1);
        list1.remove(2);
        System.out.println(list1);
        System.out.println(list1.get(2));
        list1.add(4, "six");
        System.out.println(list1);
        list1.set(0, "xXx");
        System.out.println(list1);
        list1.addAll(list1);
        System.out.println(list1);
        ListB<String> list = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(2));
        list.add(4, "six");
        System.out.println(list);
        list.set(0, "xXx");
        System.out.println(list);
        list.addAll(list);
        System.out.println(list);


    }
}
