package by.it.korennaya.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 2, 6, 8, 4, 6, 7, 8);
        List<Integer>b = Arrays.asList(5, 2, 23, 9, 3, 7, 8);
        System.out.println("а" + a);
        System.out.println("b" + b);
        Set <Integer> first = new HashSet(a);
        Set<Integer> second = new TreeSet(b);
        Set<Integer> union = getUnion (first, second);
        System.out.println("union" + union);
        Set<Integer> cross = getCross (first, second);
        System.out.println("cross" + cross);
    }

    private static Set<Integer> getUnion(Set <Integer> a, Set <Integer> b){
        Set <Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    private static Set<Integer> getCross(Set <Integer> a, Set <Integer> b) {
        Set <Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
