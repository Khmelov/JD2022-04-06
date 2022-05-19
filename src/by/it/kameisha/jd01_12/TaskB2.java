package by.it.kameisha.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        String[] names = {"1", "2", "3", "4", "5"};
        ArrayList<String> peoples = new ArrayList<>();
        LinkedList<String> peoplesLink = new LinkedList<>();
        for (String name : names) {
            peoples.add(name);
            peoplesLink.add(name);
        }
        System.out.println(process(peoples));
        System.out.println();
        String result = process(peoples);
        String resultLink = process(peoplesLink);
        System.out.println(result);
        System.out.println(resultLink);

    }

    static String process(ArrayList<String> peoples) {
        ArrayList<String> list = new ArrayList<>(peoples);
        while (list.size() > 1) {
            list = deleteSecondMan(list);
        }
        return list.get(0);
    }

    private static ArrayList<String> deleteSecondMan(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        ArrayList<String> lastPeoples = new ArrayList<>();
        int count = 2;
        if (peoples.size() != 1) {
            while (iterator.hasNext()) {
                if (count % 2 == 0) {
                    lastPeoples.add(iterator.next());
                } else {
                    iterator.next();
                }
                count++;
            }
        }
        if (count % 2 == 1 && lastPeoples.size() > 1) {
            String temporary = lastPeoples.remove(lastPeoples.size() - 1);
            lastPeoples.add(0, temporary);
        }

        return lastPeoples;
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            String temporary = peoples.removeFirst();
            peoples.addLast(temporary);
            peoples.removeFirst();
        }
        return peoples.get(0);
    }
}
