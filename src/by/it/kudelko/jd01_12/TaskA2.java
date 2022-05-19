package by.it.kudelko.jd01_12;

import by.it._examples_.jd01_10.sample_service.Service;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5, 6);
        List<Integer> second = Arrays.asList(9, 99, 8, 7, 7, 5, 6, 4);
        Set<Integer> one = new HashSet<>(first);
        Set<Integer> two = new TreeSet<>(second);
        System.out.println("one: " + one);
        System.out.println("two: " + two);
        Set<Integer> union = getUnion(one, two);
        System.out.println("getUnion: " + union);
        Set<Integer> cross = getCross(one, two);
        System.out.println("getCross: " + cross);
    }

    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
        Set<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        Set<Integer> result = new HashSet<>(left);
        result.retainAll(right);
        return result;
    }
}
