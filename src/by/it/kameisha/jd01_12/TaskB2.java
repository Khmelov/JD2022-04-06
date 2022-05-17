package by.it.kameisha.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        String[] names = {"1", "1", "3", "1", "3", "5", "7", "1", "3", "5", "7", "9", "11", "13", "15", "1"};
        ArrayList<String> peoples = new ArrayList<>();
        LinkedList<String> peoples1 = new LinkedList<>();
        for (String name : names) {
            peoples.add(name);
            peoples1.add(name);
        }
        String result = process(peoples);
        String result1 = process(peoples1);
        System.out.println(result);
        System.out.println(result1);
    }

    static int count = 2;

    static String process(ArrayList<String> peoples) {
        ArrayList<String> list = new ArrayList<>(peoples);
        while (list.size() != 1) {
            list = deleteSecondMan(list);
        }
        return list.get(0);
    }

    private static ArrayList<String> deleteSecondMan(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        ArrayList<String> lastPeoples = new ArrayList<>();
        while (iterator.hasNext()) {
            if (count % 2 == 0) {
                lastPeoples.add(iterator.next());
            } else {
                iterator.next();
            }
            count++;
        }
        return lastPeoples;
    }

    static String process(LinkedList<String> peoples) {
        LinkedList<String> linkList = new LinkedList<>(peoples);
        while (linkList.size() != 1) {
            linkList = deleteSecondManLink(linkList);
        }
        return linkList.get(0);
    }

    private static LinkedList<String> deleteSecondManLink(LinkedList<String> peoples) {
        LinkedList<String> lastPeoples = new LinkedList<>();
        Iterator<String> iterator = peoples.iterator();
        while (iterator.hasNext()) {
            if (count % 2 == 0) {
                lastPeoples.add(iterator.next());
            } else {
                iterator.next();
            }
            count++;
        }
        return lastPeoples;
    }
}
