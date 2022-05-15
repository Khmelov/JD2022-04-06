package by.it.ragach.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
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
        System.out.println(list.set(3,"seven"));
        System.out.println(list);


        HashSet<String> set = new HashSet<>();
        set.add("six");
        set.add("seven");
        set.add("eight");
        set.add("nine");
        set.add("ten");
        System.out.println(set);


        SetC<String>setC =new SetC<>();
        set.add("six");
        set.add("seven");
        set.add("eight");
        set.add("nine");
        set.add("ten");
        System.out.println(setC);


    }
}
