package by.it.kameisha.jd01_12;
import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> one = Arrays.asList(3, -5, 5, 3, 1,-4,0,9,-1,5);
        List<Integer> two = Arrays.asList(7,0,-6,1,2,-8,-2,3,3);
        Set<Integer> first = new HashSet<>(one);
        Set<Integer> second = new TreeSet<>(two);
        System.out.println("First Set "+first);
        System.out.println("Second Set "+second);
        Set<Integer>cross = getCross(first,second);
        System.out.println("Cross "+ cross);
        Set<Integer>union = getUnion(first,second);
        System.out.println("Union "+union);

    }

    private static Set<Integer> getCross(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }
}
