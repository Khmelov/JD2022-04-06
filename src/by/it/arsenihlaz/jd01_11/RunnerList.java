package by.it.arsenihlaz.jd01_11;

import java.util.*;

public class RunnerList {
    public static void main(String[] args) {
        List<String> catNameListStart = new ArrayList<>();
        List<String> catNameList = new ArrayList<>();
        catNameListStart.add("Vatrushka");
        catNameListStart.add("Chernoslivka");
        catNameListStart.add("Barsik");
        System.out.println(catNameList);
        catNameListStart.remove(2);
        System.out.println(catNameListStart);
        System.out.println("Good cat is " + catNameListStart.get(0));

        catNameList = new ListA<>();
        for (String s1 : Arrays.asList("Vatrushka", "Chernoslivka", "Barsik", "Ibragim")) {
            catNameList.add(s1);
        }
        System.out.println(catNameList);
        catNameList.remove(2);
        System.out.println(catNameList);
        System.out.println("Good cat is " + catNameList.get(0));
        
        catNameList = new ListB<>();
        for (String s : Arrays.asList("Vatrushka", "Chernoslivka", "Barsik", "Ibragim")) {
            catNameList.add(s);
        }
        System.out.println(catNameList);
        catNameList.set(2, "Barsik v2.0");
        System.out.println(catNameList);
        catNameList.add(1, "Pushistaia jopka");
        System.out.println(catNameList);
        catNameList.addAll(catNameListStart);
        System.out.println("AddAll " + catNameList);

        Set<String> catNameSet = new SetC<>();
        catNameSet.add("Vatrushka");
        System.out.println("SetC add " + catNameSet);
        System.out.println("SetC contains " + catNameSet.contains("Vatrushka"));
        System.out.println("SetC contains " + catNameSet.contains("Chernoslivka"));
        System.out.println("SetC isempty " + catNameSet.isEmpty());
        System.out.println("AddAll " + catNameList);
        catNameSet.addAll(catNameListStart);
        System.out.println("SetC addAll " + catNameSet);
        System.out.println("SetC contains "+catNameSet.contains("Vatrushka"));
        System.out.println("SetC containsAll "+catNameSet.containsAll(catNameListStart));
        System.out.println("SetC removeAll " + catNameSet);
        catNameSet.removeAll(catNameListStart);
        System.out.println("SetC removeAll " + catNameSet);
    }
}
