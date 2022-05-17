package by.it.kameisha.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>();
        LinkedList<String> peoples1 = new LinkedList<>();
        String[] names = generateRandomWords(4096);
        for (String name : names) {
            peoples1.add(name);
            peoples.add(name);
        }
        String result1 = process(peoples1);
        String result = process(peoples);
        System.out.println(result1);
        System.out.println(result);
    }


    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(9) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
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
        while (peoples.size() != 1) {
    //        String temporary = peoples.removeFirst();
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }
}
