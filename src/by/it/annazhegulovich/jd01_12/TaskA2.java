package by.it.annazhegulovich.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1,3,4,5,6,7,7);
        List<Integer> second = Arrays.asList(11, 6,7,15, 20, 22, 22);
        Set<Integer> a = new HashSet<>(first);
        Set<Integer> b = new TreeSet<>(second);
        System.out.println("one"+a);
        System.out.println("two"+b);

        Set<Integer> union = getUnion(a, b);
        System.out.println("union " +union);
        Set<Integer> cross = getCross(a, b);
        System.out.println("cross "+cross);

    }

    private static Set<Integer> getUnion (Set<Integer> left, Set<Integer> right){
        Set<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }

    private static Set<Integer> getCross (Set<Integer> left, Set<Integer> right){
        Set<Integer> result = new HashSet<>(left);
        result.retainAll(right);
        return result;
    }

}
