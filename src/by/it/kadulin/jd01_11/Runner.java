package by.it.kadulin.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Set<Short> a = new SetC<>();
        for (int i = 0; i < 10; i++) {
            a.add((short) (i * 2));
            System.out.println(a.toString());
        }
        a.remove(0);
        a.remove(8);
        a.remove(4);
        System.out.println(a.toString());
        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);
//        Long x = 10121413431412341L;
//        Long y = 10121413431412341L;
//        System.out.println(x.equals(y));
        a.addAll(added);
        a.containsAll(added);
        System.out.println(a.toString());
    }
}
