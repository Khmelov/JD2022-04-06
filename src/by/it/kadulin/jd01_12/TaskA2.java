package by.it.kadulin.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> second = Arrays.asList(1, 1, 3, 3, 5, 4, 8, 8, 9);
        Set<Integer> one = new HashSet<>(first);
        Set<Integer> two = new TreeSet<>(second);
        System.out.println(first);
        System.out.println(second);
        Set<Integer> unionRes = getUnion(one, two);
        System.out.println(unionRes);
        Set<Integer> crossRes = getCross(one, two);
        System.out.println(crossRes);


    }

    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> integers = new HashSet<>(left);
        integers.retainAll(right);
        return integers;
    }

    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> integers = new HashSet<>(left);
        integers.addAll(right);
        return integers;
    }

}
