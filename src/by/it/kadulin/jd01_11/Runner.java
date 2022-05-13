package by.it.kadulin.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//        list.add("five");
//        list.remove(2);
//        System.out.println(list);
//        System.out.printf("first=%s last=%s%n", list.get(0), list.get(list.size() - 1));
//
//        list = new ListB<>();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//        list.add("five");
//        list.remove(2);
//        System.out.println(list);
//        System.out.printf("first=%s last=%s%n", list.get(0), list.get(list.size() - 1));
        List<Long> a = new ListB<>();
        for (int i = 0; i < 10; i++) {
            a.add(i * 2L);
            System.out.println(a.toString());
        }
        System.out.println(a.toString());
        a.remove(0);
        System.out.println(a.toString());
        a.remove(8);
        System.out.println(a.toString());
        a.remove(4);
        System.out.println(a.toString());
        Long aLong = a.get(6);
        System.out.println("get from list " + aLong);
        System.out.println(a.toString());
        a.set(0, 0L);
        System.out.println(a.toString());
        a.set(6, null);
        System.out.println(a.toString());
    }
}
