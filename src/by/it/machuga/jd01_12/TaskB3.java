package by.it.machuga.jd01_12;

import java.util.*;

public class TaskB3 {

    public static final int SIZE = 4096;

    public static void main(String[] args) {
        ArrayList<String> peopleArray = new ArrayList<>();
        LinkedList<String> peopleLinked = new LinkedList<>();
        fillList(peopleArray, SIZE);
        fillList(peopleLinked, SIZE);

        long startA = System.nanoTime();
        String name = process(peopleArray);
        long timeA = System.nanoTime()-startA;
        System.out.println(name);


        long startL = System.nanoTime();
        name = process(peopleLinked);
        long timeL = System.nanoTime()-startL;
        System.out.println(name);

        System.out.printf("Время работы для ArrayList=%d нс%n", timeA);
        System.out.printf("Время работы для LinkedList=%d нс%n", timeL);
        System.out.printf("Быстрее работает %s",timeA>timeL?"LinkedList":"ArrayList");
    }

    private static String process(LinkedList<String> list) {
        processQueue(list);
        return list.getFirst();
    }

    private static void processQueue(Queue<String> list) {
        int count = 1;
        while (list.size() > 1) {
            if (count % 2 == 0) {
                list.remove();
            } else {
                list.offer(list.remove());
            }
            count++;
        }
    }

    private static String process(ArrayList<String> list) {
        processList(list);
        return list.get(0);
    }

    private static void processList(List<String> list) {
        int count = 1;
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 0) {
                    iterator.remove();
                }
                count++;
            }
        }
    }

    private static void fillList(List<String> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(String.valueOf(i));
        }
    }
}
