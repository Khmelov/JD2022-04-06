package by.it.avramchuk.jd01_11;

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
        System.out.println(list);
        System.out.printf("first=%s last=%s%n",list.get(0), list.get(list.size()-1));
        list.set(1, null);
        System.out.println(list);
        list.add(1, "one");
        System.out.println(list);
        List<String> list2 = new ArrayList<>();
        list2.add("added One");
        list2.add("added Two");
        list.addAll(0, list2);
        System.out.println(list);
        list.addAll(list2);
        System.out.println(list);
        System.out.println();


        list = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.printf("first=%s last=%s%n",list.get(0), list.get(list.size()-1));
        list.set(1, null);
        System.out.println(list);
        list.add(1, "one");
        System.out.println(list);
        list.addAll(0, list2);
        System.out.println(list);
        list.addAll(list2);
        System.out.println(list);
    }
}
