package by.it.smirnov.jd01_12;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.out;

public class TaskC2 {

    public static void main(String[] args) {
        Set<Long> a = new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L, 7L, 8L, 34L, 67L, 8L, 2L));
        Byte[] array = {11, 12, 13, 14, 17, 8, 34, 67, 8, 99, 101};
        Set<Byte> b = new TreeSet<>(Arrays.asList(array));
        Set<Float> c = new HashSet<>(Arrays.asList(11.0F, 12.0F, 13.0F, 14.0F, 17.0F, 8.0F, 34.0F));
        Set<?> crossed = getCross(a, b, c);
        Set<?> united = getUnion(a, b, c);
        out.println(crossed);
        out.println(united);
    }

    @SafeVarargs
    private static HashSet<?> getUnion(Set<? extends Number>... sets) {
        HashSet<Number> united = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            for (Number number : sets[i]) {
                if(!contains(united, number)) united.add(number);
            }
        }
        return united;
    }

    @SafeVarargs
    private static HashSet<?> getCross(Set<? extends Number>... sets) {
        HashSet<Number> crossed = new HashSet<>(sets[0]);
        HashSet<Number> remove = new HashSet<>();
        for (int i = 1; i < sets.length; i++) {
            for (Number crossedNumber : crossed) {
                if(!contains(sets[i], crossedNumber)) remove.add(crossedNumber);
            }
            crossed.removeAll(remove);
        }
        return crossed;
    }

    private static boolean contains(Set<? extends Number> set, Number number) {
        for (Number setNumber: set) {
            if(compareSets(setNumber,number)) return true;
        }
        return false;
    }

    private static boolean compareSets(Number a, Number b) {
        BigDecimal a1 = new BigDecimal(a.toString());
        BigDecimal b1 = new BigDecimal(b.toString());
        return (a1.compareTo(b1)) == 0;
    }
}
