package by.it.avramchuk.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        System.out.println(list);
        System.out.println(list.contains(null));
        System.out.println();

        Set<String> set1 = new HashSet<>();
        set1.add("one");
        set1.add("one");
        set1.add("two");
        set1.add(null);
        System.out.println(set1);
        System.out.println(set1.size());
        System.out.println(set1.contains(null));
        List<String> arr = new ArrayList<>();
        arr.add("one");
        arr.add("three");
        set1.addAll(arr);
        System.out.println(set1 + " size "+ set1.size());
        set1.remove(null);
        if (set1.containsAll(list)){

            set1.removeAll(list);
        }
        System.out.println(set1);
        set1.clear();
        System.out.println(set1+" "+set1.size());
        System.out.println(set1.isEmpty());
        System.out.println();



        Set<String> set = new SetC<>();
        set.add("one");
        set.add("one");
        set.add("two");
        set.add(null);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set1.contains(null));
        set.addAll(arr);
        System.out.println(set + " size "+ set.size());
        set.remove(null);
        if (set.containsAll(list)){

            set.removeAll(list);
        }
        System.out.println(set +"  " +set.size());
        set.clear();
        System.out.println(set+" "+set.size());
        System.out.println(set.isEmpty());


    }
}
