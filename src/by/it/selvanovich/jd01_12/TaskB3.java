package by.it.selvanovich.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();
        LinkedList<String> listL = new LinkedList<>();
        for (int n = 1; n <= 16; n++) {
            for (int i = 1; i <= n; i++) {
                listA.add("n" + i);
                listL.add("n" + i);
            }
        }
        System.out.println(listA);
        System.out.println(listL);
        System.out.println(process(listA));
        System.out.println(process(listL));
    }

    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 0) {
                    iterator.remove();
                }
                count++;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 0) {
                    iterator.remove();
                }
                count++;
            }
        }
        return peoples.get(0);

    }
}
