package by.it.machuga.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

// ArrayList
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.printf("first=%s last=%s%n", list.get(0), list.get(list.size() - 1));
        System.out.println();

//ListA
        list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.printf("first=%s last=%s%n", list.get(0), list.get(list.size() - 1));
        System.out.println();

//ListB
        list = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        List<String> temp = new ArrayList<>();
        temp.add("six");
        temp.add("seven");
        temp.add("eight");
        temp.add("nine");
        list.addAll(temp);
        System.out.println(list);

        System.out.printf("first=%s last=%s%n", list.get(0), list.get(list.size() - 1));

        list.set(3, "ten");
        System.out.println(list);

        list.add(2, "zero");
        System.out.println();

//SetC
        Set<String> set = new SetC<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        System.out.println(set);

        set.remove("two");
        System.out.println(set);

        System.out.println(set.contains("three"));
        System.out.println(set.contains("two"));
        System.out.println("set size = " + set.size());
        System.out.println("is empty? ->" + set.isEmpty());


        Set<String> hashSet = new HashSet<>();
        hashSet.add("six");
        hashSet.add("seven");
        hashSet.add("eight");
        hashSet.add("nine");
        set.addAll(hashSet);
        System.out.println(set);

        System.out.println(set.containsAll(hashSet));
        set.remove("six");
        System.out.println(set.containsAll(hashSet));

        set.removeAll(hashSet);
        System.out.println(set);

        set.clear();
        System.out.println(set);
    }
}
