package by.it.smirnov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> a = new HashSet<>();

    private static Set<Integer> b = new TreeSet<>();

    public static void main(String[] args) {
        a.addAll(Arrays.asList(1, 2, 3, 5, 7, 8, 34, 67, 8, 2));
        b.addAll(Arrays.asList(11, 12, 13, 14, 17, 8, 34, 67, 8, 99, 101));
        System.out.println(a.toString());
        System.out.println(b.toString());
        Set<Integer> crossed = getCross(a, b);
        Set<Integer> united = getUnion(a, b);
        System.out.println(crossed);
        System.out.println(united);
    }

    private static HashSet<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> crossed = new HashSet<>(a);
        crossed.retainAll(b);
        return crossed;
    }

    private static HashSet<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> united = new HashSet<>(a);
        united.addAll(b);
        return united;
    }
}
