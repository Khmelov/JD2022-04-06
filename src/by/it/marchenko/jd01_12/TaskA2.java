package by.it.marchenko.jd01_12;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1));
        Set<Integer> setB = new TreeSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        Set<Integer> crossSet = getCross(setA, setB);
        System.out.printf("Cross set %s and %s is %30s%n", setA, setB, crossSet);
        Set<Integer> unionSet = getUnion(setA, setB);
        System.out.printf("Union set %s and %s is %30s%n", setA, setB, unionSet);
    }

    private static Set<Integer> getCross(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> resultSet = new HashSet<>(setA);
        resultSet.retainAll(setB);
        return resultSet;
    }

    private static Set<Integer> getUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> resultSet = new HashSet<>(setA);
        resultSet.addAll(setB);
        return resultSet;
    }
}
