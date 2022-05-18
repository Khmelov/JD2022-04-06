package by.it.smirnov.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
/*        list.add("one");
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

 */

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
        System.out.println();
        System.out.println();

        SetC<String> set = new SetC<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        System.out.println(set);
        set.add("six");
        System.out.println(set);
        set.remove("two");
        System.out.println(set);
        System.out.println("содержит five? = " + set.contains("five"));
        System.out.println("size: " + set.size());
        System.out.println("пустой? = " + set.isEmpty());
        set.addAll(list);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println("есть элементы " +list.toString() + " ? " + set.containsAll(list));
        set.removeAll(list);
        System.out.println(set);
        System.out.println();
        System.out.println();

        HashSet<String> set2 = new HashSet<String>();
        set2.add("one");
        set2.add("two");
        set2.add("three");
        set2.add("four");
        set2.add("five");
        System.out.println(set2);
        set2.add("six");
        System.out.println(set2);
        set2.remove("two");
        System.out.println(set2);
        System.out.println("содержит five? = " + set2.contains("five"));
        System.out.println("size: " + set2.size());
        System.out.println("пустой? = " + set2.isEmpty());
        set2.addAll(list);
        System.out.println(set2);
        System.out.println(set2.size());
        System.out.println("есть элементы " +list.toString() + " ? " + set2.containsAll(list));
        set2.removeAll(list);
        System.out.println(set2);

    }
}
