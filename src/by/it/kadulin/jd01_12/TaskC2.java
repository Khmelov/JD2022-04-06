package by.it.kadulin.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        List<Number> first = Arrays.asList(1f, 2, 2.0, 2L, 3, 4);
        List<Number> second = Arrays.asList(1.0, 1, 2, 5, 5);
        Set<Number> one = new HashSet<>(first);
        Set<Number> two = new HashSet<>(second);
        System.out.println(first);
        System.out.println(second);
        Set<Number> unionRes = getUnion(one, two);
        System.out.println(unionRes);
        Set<Number> crossRes = getCross(one, two);
        System.out.println(crossRes);

    }

    private static Set<Number> getUnion(Set<Number> left, Set<Number> right) {
        HashSet<Number> numbers = new HashSet<>(left);
        Iterator<Number> iterator1 = left.iterator();
        Iterator<Number> iterator2 = right.iterator();
        while (iterator1.hasNext()) {
            Number next1 = iterator1.next();
            while (iterator2.hasNext()) {
                Number next2 = iterator2.next();
                boolean isSame = compareTo(next1, next2);
                if (isSame) {
                    numbers.add(next2.doubleValue());
                }
                if (!isSame) {
                    numbers.add(next2.doubleValue());
                }
            }
        }
//        integers.addAll(right);
        return numbers;
    }


    private static Set<Number> getCross(Set<Number> left, Set<Number> right) {
        HashSet<Number> numbers = new HashSet<>(left);
        Iterator<Number> iterator1 = left.iterator();
        Iterator<Number> iterator2 = right.iterator();
        while (iterator1.hasNext()) {
            Number next1 = iterator1.next();
            while (iterator2.hasNext()) {
                Number next2 = iterator2.next();
                boolean isSame = compareTo(next1, next2);
                if (isSame) {
                    numbers.add(next2.doubleValue());
                }
            }
        }
//        numbers.retainAll(right);
        return numbers;
    }



    private static boolean compareTo(Number next1, Number next2) {
        boolean isSame = false;
        if (next1.longValue() == next2.longValue() && next1.doubleValue() == next2.doubleValue()) {
            isSame = true;
        }
        return isSame;
    }


}
