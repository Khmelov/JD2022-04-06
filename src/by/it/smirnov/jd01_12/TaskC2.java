package by.it.smirnov.jd01_12;

import java.math.BigDecimal;
import java.util.*;

public class TaskC2 {

    private static Set<Long> a = new HashSet<>();

    private static Set<Byte> b = new TreeSet<>();

    private static Set<Float> c = new HashSet<>();

    public static void main(String[] args) {
        a.addAll(Arrays.asList(1L, 2L, 3L, 5L, 7L, 8L, 34L, 67L, 8L, 2L));
        Byte[] array = {11, 12, 13, 14, 17, 8, 34, 67, 8, 99, 101};
        b.addAll(Arrays.asList(array));
        c.addAll(Arrays.asList(11.0F, 12.0F, 13.0F, 14.0F, 17.0F, 8.0F, 34.0F));
        Set<Number> crossed = getCross(a, b, c);
        Set<Number> united = getUnion(a, b, c);
        System.out.println(crossed);
        System.out.println(united);
    }

    private static HashSet<Number> getCross(Set<Long> a, Set<Byte> b, Set<Float> c) {
        HashSet<Number> crossed = new HashSet<>();
        for (Byte aByte : b) {
            for (Long aLong : a) {
                for (Float aFloat : c) {
                    if (compadre(aByte, aLong) && compadre(aByte, aFloat)) crossed.add(aByte);
                }
            }
        }
        return crossed;
    }

    private static boolean compadre(Number a, Number b) {
        BigDecimal a1 = new BigDecimal(a.toString());
        BigDecimal b1 = new BigDecimal(b.toString());
        return (a1.compareTo(b1)) == 0;
    }

    private static HashSet<Number> getUnion(Set<Long> a, Set<Byte> b, Set<Float> c) {
        HashSet<Number> united = new HashSet<>(a);
        for (Long aLong : a) {
            for (Byte aByte : b) {
                for (Float aFloat : c) {
                    if (compadre(aByte, aLong) && compadre(aByte, aFloat)) continue;
                    else if (compadre(aByte, aFloat)) united.add(aLong);
                    else {
                        united.add(aLong);
                        united.add(aFloat);
                    }
                }
            }
        }
        return united;
    }
}
