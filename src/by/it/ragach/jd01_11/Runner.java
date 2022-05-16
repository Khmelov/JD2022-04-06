package by.it.ragach.jd01_11;

import by.it.machuga.jd01_11.ListB;
import by.it.machuga.jd01_11.SetC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        System.out.printf("first = %s last=%s%n",list.get(0), list.get(list.size()-1));
        System.out.println(list.set(3,"seven"));
        System.out.println(list);



        list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.printf("first = %s last=%s%n",list.get(0), list.get(list.size()-1));


        list = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.printf("first = %s last=%s%n",list.get(0), list.get(list.size()-1));



        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("six");
        hashSet.add("seven");
        hashSet.add("eight");
        hashSet.add("nine");
        hashSet.add("ten");
        System.out.println(hashSet);



        Set<String> set = new SetC<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        System.out.println(set);





    }
}
