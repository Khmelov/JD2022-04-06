package by.it.machuga.jd01_12;

import java.util.*;

public class TaskB2 {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        ArrayList<String> peopleArray = new ArrayList<>();
        LinkedList<String> peopleLinked = new LinkedList<>();
        fillList(peopleArray, SIZE);
        fillList(peopleLinked, SIZE);
        String name = process(peopleArray);
        System.out.println(name);
        name = process(peopleLinked);
        System.out.println(name);
    }

    private static String process(LinkedList<String> list) {
        processList(list);
        return list.getFirst();
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
