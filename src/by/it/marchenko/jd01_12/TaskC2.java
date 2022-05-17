package by.it.marchenko.jd01_12;

import java.util.*;

public class TaskC2 implements Comparator<Number>{
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1));
        Set<Integer> setB = new TreeSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        Set<Float> setC = new HashSet<>(Arrays.asList(0f, 2f, 6f, 4f, 5f, 9f, 10f, 12f));

        long maxL = Long.MAX_VALUE;
        double maxD = (double) Long.MAX_VALUE + 10000;

        double value1 = 1e8d;
        long value2 = 1000001L;

        //HashSet<Integer> setAA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1));
        //System.out.println(Number.compare(value1>value2));
        //Set<Integer> setC = new HashSet<>(Arrays.asList(0, 2, 6, 4, 5, 9, 10, 12));
        //Set<Double> setC = new HashSet<>(Arrays.asList(4.0, 5, 6, 7, 8, 9));
        //Set<Float> setD = new HashSet<>(Arrays.asList(4.0, 5, 6, 7, 8, 9));

        Set<?> crossSet = getCross(setA, setB, setC);
        System.out.printf("Cross set of %30s %30s %30s%nis %102s%n", setA, setB, setC, crossSet);
        //Set<?> unionSet = getUnion(setA, setB, setC);
        //System.out.printf("Union set of %30s %30s %30s%nis %102s%n", setA, setB, setC, unionSet);
        Comparator<Number> comparator = (o1, o2) -> {
            long difL = o1.longValue() - o2.longValue();
            double difD = o1.doubleValue() - o2.doubleValue();
            if (difL == 0 && difD == 0) {
                return 0;
            } else {
                return (int) (Math.abs(difL + difD) / (difL + difD));
            }
        };

        System.out.println(comparator.compare(value2, value1));
        System.out.println(comparator.compare(maxL, maxD));





        System.out.println("-".repeat(50));
        //double value1 = 1e8d;
        //double value2 = 1000001L;

    }


    @Override
    public int compare(Number o1, Number o2) {
        long difL = o1.longValue() - o2.longValue();
        double difD = o1.doubleValue() - o2.doubleValue();
        if (difL == 0 && difD == 0) {
            return 0;
        } else {
            return (int) (Math.abs(difL + difD) / (difL + difD));
        }
    }

    private static Set<Number> getCross(Set<? extends Number>... sets) {
        HashSet<Number> resultSet = new HashSet<>(sets[0]);
        //for (int i = 1; i < sets.length; i++) {

            //final int index = i;
            //resultSet.removeIf(o -> !sets[index].contains(o));

            //if sets[i]

        //}
        for (Set<?> set : sets) {
            //resultSet.

            resultSet.removeIf(o -> !set.contains(o));
            //resultSet.
            //resultSet.contains(set.)
            //set.contains()
            //for (Number element : set) {

            //}
            //comparator.compare()
            //resultSet.retainAll(set);
        }
        return resultSet;
    }

    private static Set<Integer> getUnion(Set<Integer>... sets) {
        Set<Integer> resultSet = new HashSet<>(sets[0]);
        for (Set<Integer> set : sets) {
            resultSet.addAll(set);
        }
        return resultSet;
    }


}
