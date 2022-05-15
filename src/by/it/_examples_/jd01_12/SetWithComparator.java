package by.it._examples_.jd01_12;

import java.util.*;

@SuppressWarnings("Convert2Lambda")
public class SetWithComparator {
    public static void main(String[] args) {
        Comparator<Integer> c= new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        Set<Integer> hashSet=new HashSet<>();
        Set<Integer> linkedHashSet=new LinkedHashSet<>();
        Set<Integer> treeSet=new TreeSet<>(c);
        treeSet.add(5); hashSet.add(5); linkedHashSet.add(5);
        treeSet.add(4); hashSet.add(4); linkedHashSet.add(4);
        treeSet.add(3); hashSet.add(3); linkedHashSet.add(3);
        treeSet.add(2); hashSet.add(2); linkedHashSet.add(2);
        treeSet.add(1); hashSet.add(1); linkedHashSet.add(1);

        System.out.println("linkedHashSet="+linkedHashSet);
        System.out.println("hashSet="+hashSet);
        System.out.println("treeSet="+treeSet);
    }
}
