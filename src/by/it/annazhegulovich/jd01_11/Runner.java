package by.it.annazhegulovich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
        System.out.printf("first : %s last : %s%n",list.get(0), list.get(list.size()-1));
        list.set(2,"e");
        System.out.println(list);
        list.add(0, "e");
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
        System.out.printf("first : %s last : %s%n",list.get(0), list.get(list.size()-1));


        list = new ListB<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println("B - "+list);
        list.remove(1);
        System.out.println("B remove- "+list);
        System.out.printf("B - "+"first : %s last : %s%n",list.get(0), list.get(list.size()-1));
        list.set(2,"e");
        System.out.println("B set- "+list);
        list.add(0, "e");
        System.out.println("B add- "+list);

        List<String> addList = new ArrayList<>();
        addList.add("six");
        addList.add("seven");
        addList.add("eight");
        addList.add("nine");
        addList.add("ten");
        addList.add("eleven");

        list.addAll(addList);
        System.out.println("B addAll- "+list);



        Set<String> c = new SetC<>() ;
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println("C - "+c);

        c.remove("two");
        System.out.println("C remove- "+c);
        System.out.println("C contains- "+c.contains("four"));
        System.out.println("C size- "+c.size());
        System.out.println("C isEmpty- "+c.isEmpty());

        c.addAll(addList);
        System.out.println("C addAll- "+c);

        HashSet<String> addSetHash = new HashSet<>() ;
        addSetHash.add("six");
        addSetHash.add("seven");
        addSetHash.add("eight");
        addSetHash.add("nine");
        addSetHash.add("ten");
        addSetHash.add("eleven");

        System.out.println("C containsAll- "+c.containsAll(addSetHash));
        System.out.println("C removeAll- "+c.removeAll(addSetHash));


        /*List<String> addList = new ArrayList<>();
        addList.add("six");
        addList.add("seven");
        addList.add("eight");
        addList.add("nine");
        addList.add("ten");
        addList.add("eleven");

        list.addAll(addList);
        System.out.println("C addAll- "+list);*/

    }
}
