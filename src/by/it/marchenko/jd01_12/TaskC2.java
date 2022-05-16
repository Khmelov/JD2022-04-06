package by.it.marchenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1));
        Set<Integer> setB = new TreeSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        Set<Integer> setC = new HashSet<>(Arrays.asList(0, 2, 6, 4, 5, 9, 10, 12));
        //Set<Double> setC = new HashSet<>(Arrays.asList(4.0, 5, 6, 7, 8, 9));
        //Set<Float> setD = new HashSet<>(Arrays.asList(4.0, 5, 6, 7, 8, 9));

        Set<?> crossSet = getCross(setA, setB, setC);
        System.out.printf("Cross set of %30s %30s %30s%nis %102s%n", setA, setB, setC, crossSet);
        Set<?> unionSet = getUnion(setA, setB, setC);
        System.out.printf("Union set of %30s %30s %30s%nis %102s%n", setA, setB, setC, unionSet);
    }

    private static Set<?> getCross(Set<?>... sets) {
        HashSet<?> resultSet = new HashSet<>(sets[0]);
        for (Set<?> set : sets) {
            resultSet.retainAll(set);
        }
        return resultSet;
    }

    private static Set<?> getUnion(Set<Integer>... sets) {
        Set<Integer> resultSet = new HashSet<>(sets[0]);
        for (Set<Integer> set : sets) {
            //for (E element : set) {

            //}
            resultSet.addAll(set);
        }
        return resultSet;
    }


}
