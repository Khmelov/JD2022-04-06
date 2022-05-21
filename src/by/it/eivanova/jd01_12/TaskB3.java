package by.it.eivanova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {
    public static final int N = 4096;

    public static void main(String[] args) {
        ArrayList<String> peopleArray = new ArrayList<>();
        LinkedList<String> peopleLinked = new LinkedList<>();
        fillList(peopleArray, N);
        fillList(peopleLinked, N);

        String names = process(peopleArray);
        System.out.println(names);

        names = process(peopleLinked);
        System.out.println(names);
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
                count ++;
            }
        }
    }

    private static void fillList(List<String> list, int N) {
        for (int i = 0; i < N; i++) {
            list.add(String.valueOf(i));
        }
    }

}
