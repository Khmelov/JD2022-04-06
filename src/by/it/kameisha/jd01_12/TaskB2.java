package by.it.kameisha.jd01_12;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        String[] names = {"Den", "Ash", "Cold", "Hot", "Water"};
        ArrayList<String> peoples = new ArrayList<>(List.of(names));
        LinkedList<String> peoples1 = new LinkedList<>();
        String result = process(peoples);
        //  String result1 = process(peoples1);
        System.out.println(result);
        //System.out.println(result1);
    }

    static int count = 2;

    static String process(ArrayList<String> peoples) {
        deleteSecondMan(peoples);
        return peoples.get(0);
    }

    private static ArrayList<String> deleteSecondMan(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        ArrayList<String> elementsDelete = new ArrayList<>();
        while (iterator.hasNext()) {
            if (count % 2 == 1) {
                elementsDelete.add(iterator.next());
                count++;
            } else {
                count++;
                iterator.next();
            }
        }
        peoples.removeAll(elementsDelete);
        while (peoples.size() > 1) {
            peoples = deleteSecondMan(peoples);
        }
        return peoples;
    }

    static String process(LinkedList<String> peoples) {
        return peoples.get(0);
    }
}
