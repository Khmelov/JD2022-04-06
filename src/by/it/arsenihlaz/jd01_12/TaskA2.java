package by.it.arsenihlaz.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {
        List<Integer> firstSet = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> secondSet = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        Set<Integer> one = new HashSet<>(firstSet);
        Set<Integer> two = new TreeSet<>(secondSet);

        Set<Integer> union = getUnion(one, two);
        System.out.println(union);

        Set<Integer> cross = getCross(one, two);
        System.out.println(cross);
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
