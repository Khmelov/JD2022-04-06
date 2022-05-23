package by.it.marchenko.jd01_12;

import java.util.*;

public class TaskC2 {//implements Comparator<Number> {

    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1));
        Set<Integer> setB = new TreeSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        Set<Float> setC = new HashSet<>(Arrays.asList(1f, 2f, 6f, 4f, 5f, 9f, 10f, 12f));

        Set<?> crossSet = getCross(setA, setC, setB);
        System.out.printf("Cross set of %30s %30s %30s%nis %102s%n", setA, setB, setC, crossSet);
        Set<?> unionSet = getUnion(setA, setB, setC);
        System.out.printf("Union set of %30s %30s %30s%nis %102s%n", setA, setB, setC, unionSet);
    }


    @SafeVarargs
    private static Set<?> getCross(Set<? extends Number>... sets) {
        Set<Number> resultSet = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            Iterator<?> resultSetIterator = resultSet.iterator();
            while (resultSetIterator.hasNext()) {
                Number resultSetElement = (Number) resultSetIterator.next();
                boolean performRemove = true;
                for (Number otherSetElement : sets[i]) {
                    if (compareNumber(resultSetElement, otherSetElement) == 0) {
                        performRemove = false;
                        break;
                    }
                }
                if (performRemove) {
                    resultSetIterator.remove();
                }
            }
        }
        return resultSet;
    }

    @SafeVarargs
    private static Set<?> getUnion(Set<? extends Number>... sets) {
        Set<Number> resultSet = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            for (Number otherSetElement : sets[i]) {
                boolean performAdd = true;
                for (Number resultSetElement : resultSet) {
                    if (compareNumber(resultSetElement, otherSetElement) == 0) {
                        performAdd = false;
                        break;
                    }
                }
                if (performAdd) {
                    resultSet.add(otherSetElement);
                }
            }
        }
        return resultSet;
    }

    public static int compareNumber(Number o1, Number o2) {
        long difL = o1.longValue() - o2.longValue();
        double difD = o1.doubleValue() - o2.doubleValue();
        if (difL == 0 && difD == 0) {
            return 0;
        } else {
            return (int) (Math.abs(difL + difD) / (difL + difD));
        }
    }
}
