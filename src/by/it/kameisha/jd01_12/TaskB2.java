package by.it.kameisha.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        String[] names = {"12", "2", "3", "4", "3", "5", "7", "10", "3", "5", "7", "9", "11", "13", "15", "16"};
        ArrayList<String> peoples = new ArrayList<>();
        LinkedList<String> peoples1 = new LinkedList<>();
        for (String name : names) {
            peoples.add(name);
            peoples1.add(name);
        }
        String result = process(peoples);
        String result1 = process(peoples1);
        System.out.println(process(peoples));
        System.out.println(process(peoples1));

    }

    static int count = 2;
    static int countLink = 2;

    static String process(ArrayList<String> peoples) {
        peoples = deleteSecondMan(peoples);
        return String.valueOf(peoples);
    }

    private static ArrayList<String> deleteSecondMan(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        ArrayList<String> lastPeoples = new ArrayList<>();
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
        if (lastPeoples.size() > 1) {
            return (deleteSecondMan(lastPeoples));
        } else {
            return lastPeoples;
        }
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            String temporary = peoples.removeFirst();
            peoples.addLast(temporary);
            peoples.removeFirst();
        }
        return String.valueOf(peoples);
    }
}
